package com.api.inventary_and_loans.services;

import com.api.inventary_and_loans.entities.Asset;
import com.api.inventary_and_loans.entities.Member;
import com.api.inventary_and_loans.repositories.AssetRepository;
import com.api.inventary_and_loans.repositories.MemberRepository;
import com.api.inventary_and_loans.dtos.AssetDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssetService {

    private final AssetRepository assetRepository;
    private final MemberRepository memberRepository;

    public AssetService(AssetRepository assetRepository, MemberRepository memberRepository) {
        this.assetRepository = assetRepository;
        this.memberRepository = memberRepository;
    }

    // Method for obtaining all the assets.
    public List<Asset> getAllAssets() {
        return assetRepository.findAll();
    }

    // Method for getting and asset by one id.
    public Optional<Asset> getAssetById(Long id) {
        return assetRepository.findById(id);
    }

    // Method for saving an asset in our database.
    public Asset saveAsset(Asset asset) {
        return assetRepository.save(asset);
    }

    // Method for deleting an asset of our database.
    public void deleteAsset(Long id) {
        assetRepository.deleteById(id);
    }

    // Method for assigning an asset to a member.
    public Asset assignAssetToMember(Long assetId, Long memberId) {
        Asset asset = assetRepository.findById(assetId)
                .orElseThrow(() -> new RuntimeException("Asset not found"));

        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("Member not found"));

        asset.setAssignedTo(member);
        return assetRepository.save(asset); // UPDATE in MySQL done.
    }

    // Method for obtaining the inventory of a member.
    public List<Asset> getAssetsByMemberId(Long memberId) {
        return assetRepository.findByAssignedToId(memberId);
    }

    // Method for transforming an asset y its dto.
    public AssetDTO convertToDTO(Asset asset) {
        AssetDTO dto = new AssetDTO();
        dto.setId(asset.getId());
        dto.setName(asset.getName());
        dto.setCategory(asset.getCategory());
        dto.setStatus(asset.getStatus());

        // If it has a member assigned we only take its first name and last name.
        if (asset.getAssignedTo() != null) {
            dto.setAssignedMemberName(asset.getAssignedTo().getFirstName() + " " + asset.getAssignedTo().getLastName());
        } else {
            dto.setAssignedMemberName("No assigned member");
        }

        return dto;
    }
}
