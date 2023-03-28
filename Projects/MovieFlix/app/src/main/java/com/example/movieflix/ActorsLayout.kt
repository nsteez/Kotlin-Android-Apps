package com.example.movieflix

//import com.codepath.articlesearch.databinding.ActivityMainBinding
//import kotlinx.serialization.json.Json
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.serialization.json.Json
import okhttp3.Headers
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject


fun createJson() = Json {
    isLenient = true
    ignoreUnknownKeys = true
    useAlternativeNames = false
}

private  const val API_KEY = "a07e22bc18f5cb106bfe4cc1f83ad8ed"
private const val ACTORS_URL =
    "https://api.themoviedb.org/3/person/popular?api_key=$API_KEY&language=en-US"


private const val TAG = "ActorsLayout/"

class ActorsLayout :  AppCompatActivity(){

    private lateinit var aRecyclerView: RecyclerView
    private val actors = mutableListOf<Actor>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_top_rated)

        Log.d(TAG, "1");

        val actorsAdapter = ActorsAdapter(this,actors)
        aRecyclerView = findViewById(R.id.actorsRv);
        aRecyclerView.adapter = actorsAdapter

        Log.d(TAG, "2");

        //aRecyclerView.layoutManager = LinearLayoutManager(this)
        aRecyclerView.layoutManager = GridLayoutManager(this, 2)

        //aRecyclerView.setAdapter(actorsAdapter);


        //Log.d(TAG, "3");

        val client = AsyncHttpClient()

        //Log.d(TAG, "4");

        client.get(ACTORS_URL, object : JsonHttpResponseHandler() {
            override fun onFailure(
                statusCode: Int,
                headers: Headers?,
                response: String?,
                throwable: Throwable?
            ) {
                //Log.d(TAG, "5");
                Log.e(TAG, "Failed to fetch actors: $statusCode")
            }

            override fun onSuccess(statusCode: Int, headers: Headers, json: JSON) {
                Log.i(TAG, "Successfully fetched actors: $json")
                try {

                   // Log.d(TAG, "6");
                    val resultsJSON: JSONArray? = json.jsonObject?.getJSONArray("results")
                        //?.getJSONArray("known_for")
                    //val res = resultsJSON.getJSONArray("known_for")

                    val data :String = resultsJSON.toString()


                    Log.d("JSon",resultsJSON.toString() );

                    val allActorsType = object:TypeToken<List<Actor>>() {}.type

                    val gson = Gson()
                    val models : List<Actor> = gson.fromJson(data, allActorsType)

                    //Log.d(TAG, "8");
                    Log.d("models",models.toString())


                    actors.addAll(models);
                    actorsAdapter.notifyDataSetChanged()



                } catch (e: JSONException) {
                    Log.e(TAG, "Exception: $e")
                }
            }
        })

        //actors.add()
    }

}