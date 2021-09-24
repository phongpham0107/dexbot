package com.dexbot.common;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Init setting key.
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class InitSetting implements InitializingBean {
	/**
	 * Checking and insert new system setting.
	 */
	@Override
	public void afterPropertiesSet() { 
	}
}
