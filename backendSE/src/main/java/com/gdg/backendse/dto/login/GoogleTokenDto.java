package com.gdg.backendse.dto.login;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class GoogleTokenDto {
    @SerializedName("access_token")
    private String accessToken;
}
