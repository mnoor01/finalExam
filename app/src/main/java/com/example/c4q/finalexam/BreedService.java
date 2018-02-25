package com.example.c4q.finalexam;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by c4q on 2/25/18.
 */

public interface BreedService {
    @GET("api/breed/{breed-name}/images/random")
    Call<ModelPuppy> getPuppies(@Path("breed-name") String breedname);

    @GET("api/breed/{breed-name}/images")
    Call<ImageModel> getImage(@Path("breed-name") String image);

}
