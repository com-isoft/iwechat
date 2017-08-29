package com.isoft.iwechat.corporation.media;

import com.isoft.iwechat.corporation.configuration.CorpConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CorpConfig.class)
public class MediaManagerTest {
    @Autowired
    MediaManager mediaManager;

    @Test
    public void upload() throws Exception {
        String mediaId = mediaManager.upload("/Users/ltt/Downloads/sample.csv", MediaType.file);

        System.out.println(mediaId);
        MediaInfo info = mediaManager.get(mediaId);
        System.out.println(info.getType() + info.getName());

        mediaId = mediaManager.upload("/Users/ltt/Downloads/sample.jpg", MediaType.image);

        System.out.println(mediaId);

        info = mediaManager.get(mediaId);
        System.out.println(info.getType() + info.getName());
    }

}