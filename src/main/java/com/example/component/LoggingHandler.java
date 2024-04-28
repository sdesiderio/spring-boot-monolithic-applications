package com.example.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.micrometer.observation.Observation;
import io.micrometer.observation.Observation.Context;
import io.micrometer.observation.ObservationHandler;

public class LoggingHandler implements ObservationHandler<Observation.Context> {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public boolean supportsContext(Context context) {
		
		return true;
	}
	
	@Override
	public void onStart(Observation.Context context) {
		
		log.info("Starting Context " + context);
		
	}
	
	@Override
	public void onError(Observation.Context context) {
		
		log.info("Error for Context " + context);
		
	}
	
	@Override
	public void onEvent(Observation.Event event,Observation.Context context) {
		
		log.info("Event for Context " + context);
		
	}
	
	@Override
	public void onScopeOpened(Observation.Context context) {
		
		log.info("Scope Opened for Context " + context);
		
	}
	
	@Override
	public void onScopeClosed(Observation.Context context) {
		
		log.info("Scope Closed for Context " + context);
		
	}
	
	
	@Override
	public void onStop(Observation.Context context) {
		
		log.info("Stopped " + context);
		
	}
	
	

}
