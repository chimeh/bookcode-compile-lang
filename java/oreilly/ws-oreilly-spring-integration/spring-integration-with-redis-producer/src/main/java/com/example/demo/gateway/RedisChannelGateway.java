package com.example.demo.gateway;

import com.example.demo.model.Post;

public interface RedisChannelGateway {
	void enqueue(Post post);
}
