package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo.model.Post;
import com.example.demo.service.ConsumerService;
import com.example.demo.util.Color;
import com.example.demo.util.ColorWriterUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("redisConsumerService")
public class RedisConsumerService implements ConsumerService {

	@Override
	public void process(Post post) {
		ColorWriterUtils.printInfo(log, Color.RED, "Received post: " + post.getTitle());
	}

}
