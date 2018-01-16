
package org.lyg.vpc.process.eda.event;

import org.lyg.vpc.process.eda.Event;
import org.lyg.vpc.process.eda.EventDispatcher;

/**
 * The {@link AbstractEvent} class serves as a base class for defining custom events happening with your
 * system. In this example we have two types of events defined.
 * <ul>
 *   <li>{@link UserCreatedEvent} - used when a user is created</li>
 *   <li>{@link UserUpdatedEvent} - used when a user is updated</li>
 * </ul>
 * Events can be distinguished using the {@link #getType() getType} method.
 */
public abstract class AbstractEvent implements Event {

  /**
   * Returns the event type as a {@link Class} object
   * In this example, this method is used by the {@link EventDispatcher} to
   * dispatch events depending on their type.
   *
   * @return the AbstractEvent type as a {@link Class}.
   */
  public Class<? extends Event> getType() {
    return getClass();
  }
}