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

    // Endpoint to assign an asset to a member. (PUT)
    @PutMapping("/{assetId}/assign/{memberId}")
    public ResponseEntity<Asset> assignAssetToMember(@PathVariable Long assetId, @PathVariable Long memberId) {
        try {
            Asset updatedAsset = assetService.assignAssetToMember(assetId, memberId);
            return ResponseEntity.ok(updatedAsset);
        } catch (RuntimeException e) {
            // If id of the asset or the member is not found, error 404 will be deployed.
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint to list all the assets of a member.
    @GetMapping("/member/{memberId}")
    public ResponseEntity<List<Asset>> getAssetsByMember(@PathVariable Long memberId) {
        List<Asset> assets = assetService.getAssetsByMemberId(memberId);
        return ResponseEntity.ok(assets);
    }
}
