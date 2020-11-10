package com.jin.com.jin;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

//configration
import org.apache.flume.Context;
//sdk
import org.apache.flume.Event;
//core
import org.apache.flume.interceptor.Interceptor;

public class CollectDayInterceptor implements Interceptor{
	@Override
	public void close() {	}
	@Override
	public void initialize() {	}
	private String getToDate() {
		SimpleDateFormat day = new SimpleDateFormat("yyyyMMdd");
		
		return day.format(new Date(System.currentTimeMillis()));
	}
	@Override
	public Event intercept(Event event) {
		String eventBody = new String(event.getBody() + ","+getToDate());
		event.setBody(eventBody.getBytes());
		return event;
	}

	@Override
	public List<Event> intercept(List<Event> events) {
		for(Event e : events)
			intercept(e);
		return events;
	}
	public static class Builder implements Interceptor.Builder{
		@Override
		public void configure(Context ctx) {	}

		@Override
		public Interceptor build() {
			return new CollectDayInterceptor();
		}
	}
}
