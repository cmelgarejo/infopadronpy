package py.com.infopadron.worker;

import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import py.com.infopadron.utils.ControlRcp;

/**
 * Created by Willynx on 25/07/15
 */

@Component("ControlRcpWorker")
public class ControlRcpWorker {

	private static final Logger logger = LoggerFactory
			.getLogger(ControlRcpWorker.class);
	private static final AtomicLong counter = new AtomicLong(0);
	private static final int MAIL_BATCH_SIZE = 50;

	@Scheduled(fixedDelay = 10000)
	public void processInternationalPrices() {
		Date now = new Date();
		long increment = counter.incrementAndGet();
		logger.trace("[" + increment + "] Running ControlRcpWorker  " + now);
//		boolean band =true;
//		if(band){
//			ControlRcp rcp = new ControlRcp();
//			rcp.controlDobleAfiliacion();
//			band=false;
//		}


	}
}
