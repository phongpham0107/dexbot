package com.dexbot.common;
//package com.dexbot.common;
//
//import java.util.HashMap;
//import java.util.List;
//
//import com.dexbot.service.BaseService;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.dexbot.portal.error.batdongsanException;
//import lombok.RequiredArgsConstructor;
//
//@ControllerAdvice
//@RequiredArgsConstructor
//public class DexbotControllerAdvice extends BaseService {
//	
//	@ExceptionHandler(value = {batdongsanException.class})
//	@ResponseBody
//	public ResponseEntity<HashMap<String, String>> handleAuthenticationException(batdongsanException e) {
//		HashMap<String, String> errorMap = new HashMap<String, String>();
//		
//		errorMap.put("message", e.getMessage());
//		
//		return new ResponseEntity<HashMap<String, String>>(errorMap, HttpStatus.INTERNAL_SERVER_ERROR);
//	}
//}
