package com.isoft.iwechat.corporation.media;

import java.io.File;

public interface MediaManager {
    /**
     * 上传临时素材
     * 图片（image）：2MB，支持JPG,PNG格式
     * 语音（voice） ：2MB，播放长度不超过60s，支持AMR格式
     * 视频（video） ：10MB，支持MP4格式
     * 普通文件（file）：20MB
     * @param filePath 文件路径
     * @return media
     */
    String upload(String filePath, MediaType type);

    /**
     * 上传临时素材
     * 图片（image）：2MB，支持JPG,PNG格式
     * 语音（voice） ：2MB，播放长度不超过60s，支持AMR格式
     * 视频（video） ：10MB，支持MP4格式
     * 普通文件（file）：20MB
     * @param file 文件
     * @return media
     */
    String upload(File file, MediaType type);

    /**
     * 获取素材内容
     * @param mediaId
     * @return
     */
    MediaInfo get(String mediaId);
}
