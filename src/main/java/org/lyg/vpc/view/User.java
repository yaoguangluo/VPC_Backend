package org.lyg.vpc.view;

import lombok.Getter;
import lombok.Setter;


/**
 * This {@link User} class is a basic pojo used to demonstrate user data sent along with
 * the {@link UserCreatedEvent} and {@link UserUpdatedEvent} events.
 */

@Getter
@Setter
public class User {
  private String userName;
  private String userAge;
}