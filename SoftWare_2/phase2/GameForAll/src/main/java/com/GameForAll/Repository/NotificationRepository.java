package com.GameForAll.Repository;

import org.springframework.data.repository.CrudRepository;

import com.GameForAll.models.Notification;

public interface NotificationRepository extends CrudRepository<Notification, Long> {

}
