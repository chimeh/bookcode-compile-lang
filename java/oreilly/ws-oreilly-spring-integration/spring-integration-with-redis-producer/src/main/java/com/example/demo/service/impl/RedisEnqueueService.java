package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.gateway.RedisChannelGateway;
import com.example.demo.model.Post;
import com.example.demo.service.EnqueueService;
import com.example.demo.util.Color;
import com.example.demo.util.ColorWriterUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RedisEnqueueService implements EnqueueService {

	private RedisChannelGateway redisChannelOutboundGateway;

	@Autowired
	public RedisEnqueueService(RedisChannelGateway redisChannelOutboundGateway) {
		this.redisChannelOutboundGateway = redisChannelOutboundGateway;
	}

	@Override
	public void enqueue(Post post) {
		ColorWriterUtils.printInfo(log, Color.BLUE, "Sending post: " + post.getTitle());
		redisChannelOutboundGateway.enqueue(post);
	}

}
