package com.trigerz.vehicle.maintenance.common.mapper;

import com.trigerz.vehicle.maintenance.persistence.entity.Invoice;
import com.trigerz.vehicle.maintenance.persistence.model.InvoiceDao;
import lombok.experimental.UtilityClass;

@UtilityClass
public class InvoiceMapper {
    public static InvoiceDao map(Invoice invoice) {
        return new InvoiceDao(invoice.getId(), invoice.getContent(), invoice.getLink(), invoice.getPrice());
    }

    public static Invoice map(InvoiceDao daoModel) {
        return Invoice.builder()
                .price(daoModel.price())
                .content(daoModel.content())
                .link(daoModel.link())
                .build();
    }
}
