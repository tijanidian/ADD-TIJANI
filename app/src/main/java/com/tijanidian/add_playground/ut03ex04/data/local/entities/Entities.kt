package com.tijanidian.add_playground.ut03ex04.data.local.entities

import androidx.room.*
import com.tijanidian.add_playground.ut03ex04.domain.CustomerModel
import com.tijanidian.add_playground.ut03ex04.domain.InvoiceLinesModel
import com.tijanidian.add_playground.ut03ex04.domain.InvoiceModel
import com.tijanidian.add_playground.ut03ex04.domain.ProductModel
import java.util.*


@Entity(tableName = "customers")
data class CustomerEntity(
    @PrimaryKey @ColumnInfo(name = "id") val customerId: Int,
    @ColumnInfo(name = "name") val customerName: String,
    @ColumnInfo(name = "surname") val customerSurname: String,
) {
    fun toModel() = CustomerModel(
        customerId,
        customerName,
        customerSurname
    )

    companion object {
        fun toEntity(customerModel: CustomerModel) = CustomerEntity(
            customerModel.id,customerModel.name,customerModel.surname
        )
    }


    @Entity(tableName = "product")
    data class ProductEntity(
        @PrimaryKey @ColumnInfo(name = "id") val productoId: Int,
        @ColumnInfo(name = "name") val productName: String,
        @ColumnInfo(name = "model") val productModel: String,
        @ColumnInfo(name = "price") val productPrice: Double,
    ) {
        fun toModel() = ProductModel(
            productoId,
            productName,
            productModel,
            productPrice
        )

        companion object {
            fun toEntity(productModel: ProductModel) = ProductEntity(
                productModel.id, productModel.name, productModel.model, productModel.price
            )
        }
    }

    @Entity(tableName = "invoiceLine")
    data class InvoiceLineEntity(
        @PrimaryKey @ColumnInfo(name = "id") val invoiceLineId: Int,
        @ColumnInfo(name = "productId") val productId: Int,
        @ColumnInfo(name = "invoiceId") val invoiceId: Int,
    ) {
        fun toModel(productEntity: ProductEntity) = InvoiceLinesModel(
            invoiceLineId,
            productEntity.toModel()
        )

        companion object {
            fun toEntity(invoiceLinesModel: InvoiceLinesModel, productId: Int,invoiceId:Int) = InvoiceLineEntity(
                invoiceLinesModel.id,
                productId,
                invoiceId,
            )
        }
    }


    @Entity(tableName = "invoice")
    data class InvoiceEntity(
        @PrimaryKey @ColumnInfo(name = "id") val invoiceId: Int,
        @ColumnInfo(name = "date") val incoiceDate: Date,
        @ColumnInfo(name = "customerId") val customerId: Int,
    ) {
        fun toModel(
            customerEntity: CustomerEntity,
            invoiceLinesModel: List<InvoiceLineEntity>,
            productEntity: ProductEntity
        ) = InvoiceModel(
            invoiceId,
            incoiceDate,
            customerEntity.toModel(),
            invoiceLinesModel.map { invoiceLineEntity ->
                invoiceLineEntity.toModel(productEntity)
            }.toMutableList()

        )
    }


    /**
     * Una factura está asociada a UN cliente InvoiceAndCustomer
     */

    data class InvoiceLineAndProduct(
        @Embedded val invoiceEntity:InvoiceEntity,
        @Relation(
            parentColumn = "id",
            entityColumn = "customerId"
        ) val customerEntity: CustomerEntity
    )


    /**
     * Una factura pude tener una o varias líneas de factura
     */
    data class InvoiceAndCustomerAndInvoiceLine(
        @Embedded val invoiceEntity: InvoiceEntity,

        @Relation(
            parentColumn = "id",
            entityColumn = "customerId"
        ) val customerEntity: CustomerEntity,

        @Relation(
            parentColumn = "id",
            entityColumn = "invoiceId"
        )val invoiceLineEntities: List<InvoiceLineEntity>
    )

}