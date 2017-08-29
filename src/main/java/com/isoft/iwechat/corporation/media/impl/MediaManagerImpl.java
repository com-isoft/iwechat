package com.isoft.iwechat.corporation.media.impl;

import com.isoft.iwechat.core.RequestFailedException;
import com.isoft.iwechat.core.TokenManager;
import com.isoft.iwechat.core.WeChatRestClient;
import com.isoft.iwechat.corporation.CorpConstant;
import com.isoft.iwechat.corporation.media.MediaInfo;
import com.isoft.iwechat.corporation.media.MediaManager;
import com.isoft.iwechat.corporation.media.MediaType;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.*;
import org.springframework.util.Assert;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.MediaType.MULTIPART_FORM_DATA;

public class MediaManagerImpl implements MediaManager {
    private final static String BASE_URL = CorpConstant.BASE_URL + "/media";
    private final static String UPLOAD_URL = BASE_URL + "/upload";
    private final static String GET_URL = BASE_URL + "/get";

    private WeChatRestClient weChatRestClient;
    private TokenManager tokenManager;

    public MediaManagerImpl(WeChatRestClient weChatRestClient, TokenManager tokenManager) {
        this.weChatRestClient = weChatRestClient;
        this.tokenManager = tokenManager;
    }

    /**
     * 上传临时素材
     *
     * @param filePath 文件路径
     * @return media
     */
    @Override
    public String upload(String filePath, MediaType type) {
        Assert.notNull(filePath, "文件路径不能为空!");
        Assert.notNull(type, "素材类型不能为空！");

        return upload(new File(filePath), type);
    }

    /**
     * 上传临时素材
     *
     * @param file 文件
     * @return media
     */
    @Override
    public String upload(File file, MediaType type) {
        Assert.notNull(type, "素材类型不能为空！");
        if (!file.isFile() || !file.exists()) {
            throw new IllegalArgumentException("文件路径不正确！");
        }

        String ext = file.getName().substring(file.getName().lastIndexOf(".")).toLowerCase();
        long fileSize = file.length();

        if (type == MediaType.image) {

            if (!ext.equals(".jpg") && !ext.equals(".png")) {
                throw new IllegalStateException("类型为image的素材，扩展名只能为.jpg .png!");
            }

            if (fileSize > 2 * 1024 * 1024) {
                throw new IllegalStateException("类型为image的素材，最大2M!");
            }
        }

        if (type == MediaType.video) {
            if (!ext.equals(".mp4")) {
                throw new IllegalStateException("类型为video的素材，扩展名只能为.mp4");
            }

            if (fileSize > 10 * 1024 * 1024) {
                throw new IllegalStateException("类型为video的素材，最大10M!");
            }
        }

        if (type == MediaType.voice) {
            if (!ext.equals(".amr")) {
                throw new IllegalStateException("类型为voice的素材，扩展名只能为.amr");
            }
            if (fileSize > 2 * 1024 * 1024) {
                throw new IllegalStateException("类型为voice的素材，最大2M!");
            }
        }

        if (type == MediaType.file) {
            if (fileSize > 20 * 1024 * 1024) {
                throw new IllegalStateException("类型为file的素材，最大20M!");
            }
        }


        FileSystemResource resource = new FileSystemResource(file);
        MultiValueMap<String, Object> parts = new LinkedMultiValueMap<>();
        parts.add("media", resource);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MULTIPART_FORM_DATA);

        HttpEntity<MultiValueMap<String, Object>> requestEntity =
                new HttpEntity<>(parts, headers);

        Map<String, String> variables = new HashMap<>();
        variables.put("access_token", tokenManager.getToken(CorpConstant.ADDRESS_BOOK_AGENT_ID));
        variables.put("type", type.name());

        MediaResponse response = weChatRestClient.postForObject(UPLOAD_URL, requestEntity, MediaResponse.class, variables);
        return response.getMediaId();
    }

    /**
     * 获取素材内容
     *
     * @param mediaId
     * @return
     */
    @Override
    public MediaInfo get(String mediaId) {
        Assert.notNull(mediaId, "素材id不能为空！");

        MediaInfo mediaInfo = new MediaInfo();

        Map<String, String> variables = new HashMap<>();
        variables.put("access_token", tokenManager.getToken(CorpConstant.ADDRESS_BOOK_AGENT_ID));
        variables.put("media_id", mediaId);

        ResponseEntity<byte[]> response = weChatRestClient.exchange(GET_URL, HttpMethod.GET, null, byte[].class, variables);

        if (response.getStatusCode() != HttpStatus.OK) {
            throw new RequestFailedException(Integer.parseInt(response.getHeaders().get("errcode").get(0)), response.getHeaders().get("errmsg").get(0));
        }

        String fileDescription = response.getHeaders().get("Content-disposition").get(0);

        String fileName = fileDescription.substring(fileDescription.indexOf("\"") + 1, fileDescription.lastIndexOf("\""));
        String fileExtension = fileName.substring(fileName.lastIndexOf(".")).toLowerCase();

        switch (fileExtension) {
            case ".jpg":
            case ".png":
                mediaInfo.setType(MediaType.image);
                break;
            case ".amr":
                mediaInfo.setType(MediaType.voice);
                break;
            case ".mp4":
                mediaInfo.setType(MediaType.video);
                break;
            default:
                mediaInfo.setType(MediaType.file);
                break;
        }

        mediaInfo.setId(mediaId);
        mediaInfo.setContent(response.getBody());
        mediaInfo.setName(fileName);

        return mediaInfo;
    }
}
