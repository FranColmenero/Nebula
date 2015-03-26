package org.eclipse.nebula.widgets.ganttchart.themes;

import org.eclipse.nebula.widgets.ganttchart.AbstractColorManager;
import org.eclipse.nebula.widgets.ganttchart.ColorCache;
import org.eclipse.swt.graphics.Color;

/**
 * Default gantt color theme
 * @author emdo
 *
 */
public class ColorThemeDefault extends AbstractColorManager
{
   @Override
   public Color getArrowColor() 
   {
      return ColorCache.getColor(255, 0, 0);
   }
}
