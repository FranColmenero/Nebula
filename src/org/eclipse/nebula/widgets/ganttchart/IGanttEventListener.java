/*******************************************************************************
 * Copyright (c) Emil Crumhorn - Hexapixel.com - emil.crumhorn@gmail.com
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    emil.crumhorn@gmail.com - initial API and implementation
 *******************************************************************************/

package org.eclipse.nebula.widgets.ganttchart;

import java.util.Calendar;
import java.util.List;

import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.GC;

interface IGanttEventListener {

	/**
	 * Fires when one or more events were moved.
	 * 
	 * @param events List of modified events (post modification)
	 * @param mouseEvent MouseEvent
	 */
	void eventsMoved(List events, MouseEvent mouseEvent);

	/**
	 * Fires when one or more events were resized.
	 * 
	 * @param events List of modified events (post modification)
	 * @param mouseEvent MouseEvent
	 */
	void eventsResized(List events, MouseEvent mouseEvent);
	/**
	 * Check if the event is FP move event
	 * @param event: GanttEvent
	 * @param mouseEvent: MouseEvent
	 */
	boolean allowNodeMoved(GanttEvent event, MouseEvent mouseEvent);
	/**
	 * Check if the event is the FP resize event
	 * @param event: GanttEvent
	 * @param mouseEvent: MouseEvent
	 */
	boolean allowNodeResized(GanttEvent event, MouseEvent mouseEvent);

	/**
	 * Fires when a move has finished (the mouse button is let go).
	 * 
	 * @param events List of modified events (post modification)
	 * @param mouseEvent MouseEvent
	 */
	void eventsMoveFinished(List events, MouseEvent mouseEvent);

	/**
	 * Fires when a resize has finished (the mouse button is let go).
	 * 
	 * @param events List of modified events (post modification)
	 * @param mouseEvent MouseEvent
	 */
	void eventsResizeFinished(List events, MouseEvent mouseEvent);

    /**
     * Fires when a GanttPhase was moved.
     * 
     * @param phase GanttPhase that was moved
     * @param mouseEvent MouseEvent
     */
    void phaseMoved(GanttPhase phase, MouseEvent mouseEvent);

    /**
     * Fires when a GanttPhase was resized.
     * 
     * @param phase GanttPhase that moved
     * @param mouseEvent MouseEvent
     */
    void phaseResized(GanttPhase phase, MouseEvent mouseEvent);

    /**
     * Fires when a move has finished on a GanttPhase (the mouse button is let go).
     * 
     * @param phase GanttPhase that was moved
     * @param mouseEvent MouseEvent
     */
    void phaseMoveFinished(GanttPhase phase, MouseEvent mouseEvent);

    /**
     * Fires when a resize has finished on a GanttPhase (the mouse button is let go).
     * 
     * @param phase GanttPhase that was resized
     * @param mouseEvent MouseEvent
     */
    void phaseResizeFinished(GanttPhase phase, MouseEvent mouseEvent);
	
	/**
	 * Fires when an event is selected.
	 * 
	 * @param event Event that got selected.
	 * @param allSelectedEvents All currently selected events.
	 * @param mouseEvent MouseEvent
	 */
	void eventSelected(GanttEvent event, List allSelectedEvents, MouseEvent mouseEvent);

	/**
	 * Fires when the built-in delete action is run on an event.
	 * 
	 * @param events Events requested to be deleted
	 * @param mouseEvent MouseEvent
	 */
	void eventsDeleteRequest(List events, MouseEvent mouseEvent);

	/**
	 * Fires when an event is doubleclicked.
	 * 
	 * @param event Event double clicked.
	 * @param mouseEvent MouseEvent
	 */
	void eventDoubleClicked(GanttEvent event, MouseEvent mouseEvent);

	/**
	 * Fires when user zoomed in.
	 * 
	 * @param newZoomLevel The new zoom level.
	 */
	void zoomedIn(int newZoomLevel);

	/**
	 * Fires when user zoomed out.
	 * 
	 * @param newZoomLevel The new zoom level.
	 */
	void zoomedOut(int newZoomLevel);

	/**
	 * Fires when the zoom level has been reset.
	 * 
	 */
	void zoomReset();

	/**
	 * Fires when the "properties" menu item is selected on an event (assuming it's visible).
	 * 
	 * @param events Events to show properties on.
	 */
	void eventPropertiesSelected(List events);

	/**
	 * Fires when a header section becomes selected (days in the header are clicked etc).
	 * 
	 * @param newlySelectedDate The date that was just clicked
	 * @param allSelectedDates All dates that were selected previously including the currently added one
	 */
	void eventHeaderSelected(Calendar newlySelectedDate, List allSelectedDates);

	/**
	 * This method will be called when the chart has finished drawing. It passes along the GC object for any custom drawing you may wish to do on top of the currently drawn chart.
	 * 
	 * @param gc GC graphics object
	 */
	void lastDraw(GC gc);
	
	/**
	 * This is called when an event is moved (vertical DND) from one section to another.
	 * 
	 * @param event Event that was moved 
	 * @param oldSection Section it used to belong to
	 * @param newSection Section it belongs to now
	 */
	void eventMovedToNewSection(GanttEvent event, GanttSection oldSection, GanttSection newSection);
	
	/**
	 * This is called when an event was reordered vertically in the chart (via DND).
	 * 
	 * @param event Event that was reordered
	 */
	void eventReordered(GanttEvent event);
	
	/**
	 * This is called when the horizontal scroll value is changed
	 * 
	 * @param position
	 */
	void hScrollMoved();
}
