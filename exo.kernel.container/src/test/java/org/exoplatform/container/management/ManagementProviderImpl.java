/*
 * Copyright (C) 2009 eXo Platform SAS.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.exoplatform.container.management;

import org.exoplatform.management.spi.*;
import org.exoplatform.management.spi.ManagedResource;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author <a href="mailto:julien.viet@exoplatform.com">Julien Viet</a>
 * @version $Revision$
 */
public class ManagementProviderImpl implements ManagementProvider
{

   /** . */
   final List<org.exoplatform.container.management.ManagedResource> resources = new ArrayList<org.exoplatform.container.management.ManagedResource>();

   public Object manage(ManagedResource context)
   {
      org.exoplatform.container.management.ManagedResource mr = new org.exoplatform.container.management.ManagedResource(context.getResource(), context, context.getMetaData());
      resources.add(mr);
      return mr.key;
   }

   public void unmanage(Object key)
   {
      for (Iterator<org.exoplatform.container.management.ManagedResource> i = resources.iterator();i.hasNext();)
      {
         org.exoplatform.container.management.ManagedResource mr = i.next();
         if (mr.key == key)
         {
            i.remove();
            break;
         }
      }
   }
}