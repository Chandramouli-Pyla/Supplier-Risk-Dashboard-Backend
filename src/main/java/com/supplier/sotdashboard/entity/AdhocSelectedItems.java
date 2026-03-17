package com.supplier.sotdashboard.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "adhoc_selected_items")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdhocSelectedItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "panel_key", nullable = false, unique = true)
    private String panelKey;

    @Lob
    @Column(columnDefinition = "LONGTEXT", nullable = false)
    private String selectedItemsJson;
}