package org.lyg.vpc.process.eda;

/**
 * A {@link Event} is an object with a specific type that is associated
 * to a specific {@link Handler}.
 */
public interface Event {

  /**
   * Returns the message type as a {@link Class} object. In this example the message type is
   * used to handle events by their type.
   * @return the message type as a {@link Class}.
   */
  Class<? extends Event> getType();
}