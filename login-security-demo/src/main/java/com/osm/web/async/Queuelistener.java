/**
 * 
 */
package com.osm.web.async;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


/**
 * @author ouShiMing
 *
 */
@Component
public class Queuelistener implements ApplicationListener<ContextRefreshedEvent> {
	@Autowired
	private MsgQueue msgQueue;
	
	@Autowired
	private DeferredResultHolder deferredResultHolder;
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		new Thread(() ->  {
			while (true) {
				if (StringUtils.isNotBlank(msgQueue.getCompleteOrder())) {
					String orderNumber = msgQueue.getCompleteOrder();
					logger.info("返回订单处理结果" + orderNumber);
					deferredResultHolder.getMap().get(orderNumber).setResult("place order success");
					msgQueue.setCompleteOrder(null);
				}
				else { 
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();

	}
	
	
}
