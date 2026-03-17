package com.supplier.sotdashboard.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "adhoc_filter_panels")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdhocFilterPanel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String panelKey;

    @Column(nullable = false)
    private String title;

    @Column(name = "count_label", nullable = false)
    private String countLabel;

    @Lob
    @Column(columnDefinition = "LONGTEXT", nullable = false)
    private String itemsJson;
}