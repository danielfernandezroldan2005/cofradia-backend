package com.api.inventary_and_loans.controllers;

import com.api.inventary_and_loans.entities.Asset;
import com.api.inventary_and_loans.services.AssetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assets")
public class AssetController {

    private final AssetService assetService;

    public AssetController(AssetService assetService) {
        this.assetService = assetService;
    }

    // Endpoint for getting all the assets. (GET)
    @GetMapping
    public List<Asset> getAllAssets() {
        return assetService.getAllAssets();
    }

    // Endpoint to look for and asset by id. (GET)
    @GetMapping("/{id}")
    public ResponseEntity<Asset> getAssetById(@PathVariable Long id) {
        return assetService.getAssetById(id)
                .map(asset -> ResponseEntity.ok(asset))
                .orElse(ResponseEntity.notFound().build());
    }

    // Endpoint to add a new asset. (POST)
    @PostMapping
    public Asset createAsset(@RequestBody Asset asset) {
        return assetService.saveAsset(asset);
    }

    // Endpoint to delete an asset. (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAsset(@PathVariable Long id) {
        assetService.deleteAsset(id);
        return ResponseEntity.noContent().build();
    }
}
