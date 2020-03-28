package com.soft1851.spring.web.service;

import com.soft1851.spring.web.entity.Topic;

import javax.sound.midi.VoiceStatus;
import java.util.List;

/**
 * @ClassName TopicService
 * @Description TODO
 * @Author yue_fan
 * @Date 2020/3/27
 **/
public interface TopicService {
    List<Topic> queryAll();
    void addTopic(Topic topic);
    int[] batchInsert(List<Topic> topics);
}
