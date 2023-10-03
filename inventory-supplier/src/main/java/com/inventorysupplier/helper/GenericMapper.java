package com.inventorysupplier.helper;

import com.inventorysupplier.dto.DistributorDto;
import com.inventorysupplier.dto.SupplierDto;
import com.inventorysupplier.dto.WarehouseDto;
import com.inventorysupplier.entity.Distributor;
import com.inventorysupplier.entity.Supplier;
import com.inventorysupplier.entity.Warehouse;

public class GenericMapper {

	public static Distributor distributorDtoToEntity(DistributorDto distributorDto) {
		return Distributor.builder().name(distributorDto.getName())
				.distributorId(distributorDto.getDistributorId() != null ? distributorDto.getDistributorId() : null)
				.location(distributorDto.getLocation()).phoneNo(distributorDto.getPhoneNo()).build();
	}

	public static Supplier supplierDtoToEntity(SupplierDto supplierDto) {
		return Supplier.builder().name(supplierDto.getName())
				.supplierId(supplierDto.getSupplierId() != null ? supplierDto.getSupplierId() : null)
				.location(supplierDto.getLocation()).phoneNo(supplierDto.getPhoneNo()).build();
	}

	public static Warehouse warehouseDtoToEntity(WarehouseDto warehouseDto) {
		return Warehouse.builder().name(warehouseDto.getName())
				.warehouseId(warehouseDto.getWarehouseId() != null ? warehouseDto.getWarehouseId() : null)
				.description(warehouseDto.getDescription()).build();
	}
}
