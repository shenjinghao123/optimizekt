package top.horsttop.appcore.model.pojo;

import com.google.auto.value.AutoValue;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.Gson;

@AutoValue
public abstract class UserPersistence{

	@SerializedName("uId")
	public abstract int uId();

	@SerializedName("jsonStr")
	public abstract String jsonStr();

	public static TypeAdapter<UserPersistence> typeAdapter(Gson gson) {
		return new AutoValue_UserPersistence.GsonTypeAdapter(gson);
	}


}