package org.eclipse.nebula.widgets.ganttchart;

import java.util.Calendar;

class ViewPortHandler {

	private GanttComposite _ganttComposite;
	
	public ViewPortHandler(GanttComposite parent) {
		_ganttComposite = parent;
	}
	
	public void scrollingLeft() {
		scrollingLeft(1);
	}
	
	public void scrollingLeft(int diff) {
		
		_ganttComposite.showScrollDate();
		
		if (diff == 0){
			diff = 1;
		}
		
		switch (_ganttComposite.getCurrentView()) {
    	case ISettings.VIEW_YEAR:
    		// year scrolls so fast that the events actually lose position,
    		// this is no good, so we need to break the speed
    		if (diff > 7) 
    			diff = 7;
    		prevMonth(diff);
    		break;
    	case ISettings.VIEW_MONTH:
    		//prevWeek(diff);
    		prevDay(diff);
    		break;
    	case ISettings.VIEW_WEEK:
    		prevDay(diff);
    		break;	
    	case ISettings.VIEW_DAY:
    		prevHour(diff);
    		break;
    	case ISettings.VIEW_HOURS:
    		prevMinute(diff);
    		break;
		}
		return;
	}
	
	public void scrollingRight() {
		scrollingRight(1);
	}
	public void scrollingRight(int diff) {
		
		_ganttComposite.showScrollDate();
		
		if (diff == 0){
			diff = 1;
		}

		switch (_ganttComposite.getCurrentView()) {
    	case ISettings.VIEW_YEAR:
    		// year scrolls so fast that the events actually lose position,
    		// this is no good, so we need to break the speed
    		if (diff > 7) 
    			diff = 7;
    		nextMonth(diff);
    		break;
    	case ISettings.VIEW_MONTH:
    		//nextWeek(diff);
    		nextDay(diff);
    		break;
    	case ISettings.VIEW_WEEK:
    		nextDay(diff);
    		break;	
    	case ISettings.VIEW_DAY:
    		nextHour(diff);
    		break;
    	case ISettings.VIEW_HOURS:
    		nextMinute(diff);
    		break;
		}
		return;
	}

	/**
	 * Jumps to the next month.
	 */
	public void nextMonth() {
		nextMonth(1);
	}
	/**
	 * Jumps n months forward.
	 */
	public void nextMonth(int nMonths) {
		Calendar mCalendar = _ganttComposite.getRootCalendar();
		mCalendar.add(Calendar.MONTH, nMonths);

		_ganttComposite.setNoRecalc();
		_ganttComposite.moveXBounds(false,nMonths*_ganttComposite.getDayWidth());
		_ganttComposite.redraw();
	}
	/**
	 * Jumps to the previous month.
	 */
	public void prevMonth() {
		prevMonth(1);
	}
	/**
	 * Jumps n months backwards.
	 */
	public void prevMonth(int nMonths) {
		Calendar mCalendar = _ganttComposite.getRootCalendar();
		mCalendar.add(Calendar.MONTH, -nMonths);

		_ganttComposite.setNoRecalc();
		_ganttComposite.moveXBounds(true,nMonths*_ganttComposite.getDayWidth());

		_ganttComposite.redraw();
	}

	/**
	 * Jumps one week forward.
	 */
	public void nextWeek() {
		nextWeek(1);
	}
		
	/**
	 * Jumps n weeks forward.
	 */
	public void nextWeek(int nWeeks) {
		Calendar mCalendar = _ganttComposite.getRootCalendar();
		mCalendar.add(Calendar.DATE, 7*nWeeks);

		_ganttComposite.setNoRecalc();
		_ganttComposite.moveXBounds(false,nWeeks*_ganttComposite.getDayWidth());
		_ganttComposite.redraw();
	}

	/**
	 * Jumps one week backwards.
	 */
	public void prevWeek() {
		prevWeek(1);
	}
	
	/**
	 * Jumps n weeks backwards.
	 */
	public void prevWeek(int nWeeks) {
		Calendar mCalendar = _ganttComposite.getRootCalendar();
		mCalendar.add(Calendar.DATE, -7*nWeeks);

		_ganttComposite.setNoRecalc();
		_ganttComposite.moveXBounds(true,nWeeks*_ganttComposite.getDayWidth());
		_ganttComposite.redraw();
	}

	/**
	 * Jumps to the next hour.
	 */
	public void nextHour() {
		nextHour(1);
	}
	
	/**
	 * Jumps n hours forward.
	 */
	public void nextHour(int nHours) {
		Calendar mCalendar = _ganttComposite.getRootCalendar();
		mCalendar.add(Calendar.HOUR_OF_DAY, nHours);
		
		_ganttComposite.setNoRecalc();
		_ganttComposite.moveXBounds(false,nHours*_ganttComposite.getDayWidth());
		_ganttComposite.redraw();
	}

	/**
	 * Jumps to the previous hour.
	 */
	public void prevHour() {
		prevHour(1);
	}
	
	/**
	 * Jumps n hours backward.
	 */
	public void prevHour(int nHours) {
		Calendar mCalendar = _ganttComposite.getRootCalendar();		
		mCalendar.add(Calendar.HOUR_OF_DAY, -nHours);	

		// move events
		_ganttComposite.setNoRecalc();
		_ganttComposite.moveXBounds(true,nHours*_ganttComposite.getDayWidth());
		_ganttComposite.redraw();
	}

	/**
	 * Jumps one day forward.
	 */
	public void nextDay() {
		nextDay(1);
	}
	/**
	 * Jumps n days forward.
	 */
	public void nextDay(int nDays) {
	
		Calendar mCalendar = _ganttComposite.getRootCalendar();
		mCalendar.add(Calendar.DATE, nDays);
		//mCalendar.set(Calendar.HOUR_OF_DAY, 0);

		_ganttComposite.moveXBounds(false,nDays*_ganttComposite.getDayWidth());
		_ganttComposite.setNoRecalc();
		_ganttComposite.redraw();
	}

	/**
	 * Jumps one day backwards.
	 */
	public void prevDay() {
		prevDay(1);
	}
	/**
	 * Jumps n days backwards.
	 */
	public void prevDay(int nDays) {
		Calendar mCalendar = _ganttComposite.getRootCalendar();
		mCalendar.add(Calendar.DATE, -nDays);
		//mCalendar.set(Calendar.HOUR_OF_DAY, 0);

		_ganttComposite.moveXBounds(true,nDays*_ganttComposite.getDayWidth());
		_ganttComposite.setNoRecalc();
		_ganttComposite.redraw();
	}
	
	// add by cjmc for minutes jumps [Begin]
	
	/**
	 * Jumps to the next minutes.
	 */
	public void nextMinute() {
		nextMinute(1);
	}
	/**
	 * Jumps n minutes forward.
	 */
	public void nextMinute(int nMinutes) {
		Calendar mCalendar = _ganttComposite.getRootCalendar();
		mCalendar.add(Calendar.MINUTE, nMinutes);

		_ganttComposite.setNoRecalc();
		_ganttComposite.moveXBounds(false,nMinutes*_ganttComposite.getDayWidth());
		_ganttComposite.redraw();
	}

	/**
	 * Jumps to the previous minutes.
	 */
	public void prevMinute() {
		prevMinute(1);
	}
	
	/**
	 * Jumps n minutes backward.
	 */
	public void prevMinute(int nMinutes) {
		Calendar mCalendar = _ganttComposite.getRootCalendar();
		mCalendar.add(Calendar.MINUTE, -nMinutes);

		_ganttComposite.setNoRecalc();
		_ganttComposite.moveXBounds(true,nMinutes*_ganttComposite.getDayWidth());
		_ganttComposite.redraw();
	}
	
}
