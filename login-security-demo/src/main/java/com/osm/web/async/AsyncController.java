/**
 * 
 */
package com.osm.web.async;



import java.util.concurrent.Callable;

import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;



/**
 * @author ouShiMing
 *
 */
@RestController
public class AsyncController {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	/*@RequestMapping("/order")
	public String order() throws InterruptedException {
		logger.info("主线程开始");
		Thread.sleep(1000);
		logger.info("主线程结束");
		return "success";
	}*/
	
/*		使用Callable
 * 	@RequestMapping("/order")
	public Callable<String> order() throws InterruptedException {
		logger.info("主线程开始");
		Callable<String> result = new Callable<String>() {
			@Override
			public String call() throws InterruptedException {
				logger.info("副线程开始");	
				Thread.sleep(1000);
				logger.info("副线程结束");
				return "Success";
			}
		};
		logger.info("主线程结束");
		return result;
	}*/
	
	@Autowired
	private MsgQueue msgQueue;

	@Autowired
	private DeferredResultHolder deferredResultHolder;
	
	@RequestMapping("/order")
	public DeferredResult<String> order() throws InterruptedException {
		logger.info("主线程开始");
		
		String orderNumber = RandomStringUtils.randomNumeric(8);
		msgQueue.setPlaceOrder(orderNumber);
		
		DeferredResult<String> result = new DeferredResult<>();
		deferredResultHolder.getMap().put(orderNumber, result);
		
		logger.info("主线程结束");
		return result;
	}
	 
}
