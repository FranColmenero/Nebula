/*******************************************************************************
 * Copyright (c) Emil Crumhorn - Hexapixel.com - emil.crumhorn@gmail.com
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    emil.crumhorn@gmail.com - initial API and implementation
 *******************************************************************************/

package org.eclipse.nebula.widgets.ganttchart.undoredo.commands;

import java.util.ArrayList;
import java.util.List;

/**
 * One command to handle many sub-commands, such as a multi-drag/drop etc
 * 
 * @author cre
 *
 */
public class ClusteredCommand extends AbstractUndoRedoCommand {

    private final List _commands;
    
    public ClusteredCommand() {
        super();
        _commands = new ArrayList();
    }
    
    public ClusteredCommand(final List commands) {
        super();
        _commands = commands;
    }
    
    public void addCommand(final IUndoRedoCommand command) {
        _commands.add(command);
    }
    
    public void removeCommand(final IUndoRedoCommand command) {
        _commands.remove(command);
    }
    
    public int size() {
        return _commands.size();
    }
    
    public void dispose() {
        for (int i = 0; i < _commands.size(); i++) {
            ((IUndoRedoCommand)_commands.get(i)).dispose();
        }
    }

    public void redo() {
        for (int i = 0; i < _commands.size(); i++) {
            ((IUndoRedoCommand)_commands.get(i)).redo();
        }
    }

    public void undo() {
        for (int i = 0; i < _commands.size(); i++) {
            ((IUndoRedoCommand)_commands.get(i)).undo();
        }
    }
    
    public List getCommandList(){
    	return _commands;
    }

}
