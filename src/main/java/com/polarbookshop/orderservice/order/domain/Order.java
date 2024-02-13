package com.polarbookshop.orderservice.order.domain;

import java.time.Instant;
import lombok.Builder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.Table;

@Builder
@Table("orders")
public record Order(
		@Id
		Long id,
		String isbn,
		String title,
		Double price,
		Integer quantity,
		OrderStatus status,
		@CreatedDate
		Instant createDate,
		@LastModifiedDate
		Instant lastModifiedDate,
		@Version
		int version) {
	public static Order of(String isbn, String name, Double price, Integer quantity, OrderStatus status) {
		return new Order(null, isbn, name, price, quantity, status, null, null, 0);
	}
}
