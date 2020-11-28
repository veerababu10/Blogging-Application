package com.cg.blogging.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.blogging.dao.CommunityJPARepository;
import com.cg.blogging.entities.Blogger;
import com.cg.blogging.entities.Community;


@Service
public class CommunityServiceImpl implements CommunityService{
	
	@Autowired
	private CommunityJPARepository communityJPARepository;


}