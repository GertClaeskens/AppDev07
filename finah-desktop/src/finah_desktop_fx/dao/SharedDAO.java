package finah_desktop_fx.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import finah_desktop_fx.model.Vraag;

public class SharedDAO {

	public static BufferedReader HaalGegevens(String url)
			throws ClientProtocolException, IOException {

		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(url);
		request.setHeader("Authorization", "Bearer ZfmgrSW85TXRy9V_xQ7t7NIRiydl0iITdYCcbCTfLwFuWYbphfEy7oCgBOTSvmRLYBR0ZQ9IzW2Ot7Ayln3UXpez1ZDEX8v5N1Y3uF_HXddnvr-5xPTa0W1B9_dDfqHIqwI8UJruM-ZkrssERWFuAPypztcPsj3vsB0DOtz63u1npCqWGt5mJj6HBoYf8WL9wt70ndzXvde6qDZ54yTQRs1tEWC0ZzteAZjhrVp1KHOyDhzXB70mjbMWJWIYLGiDghp9iTINV4LtI-CuH7Gd1t504Z7TPF1wRrDuNznMcKLurcoMktPxpAsVzWNy1prlfhumpMFRu8zTww0lqVjjXOJvXNIhDORnPd1ITwRPS-WG8sJrsFDeU_W7nhFcycLSM4EtkOpAaRcidhqXUL_WlEsgu_9Sq8-bNNPVSxto0KCo0Eb04JXppLCp-eR2rbYc-mV_RIcIqRKNU4zWO3k4voxH6UCoiigtTDY24NpD6mpiII59ZvwEsNaCsYplZY8EyWry26ZfL8uk3-buoOgoMg");
		HttpResponse response = client.execute(request);
		BufferedReader rd = new BufferedReader(new InputStreamReader(response
				.getEntity().getContent()));

		return rd;
	}
	public static <T> ArrayList<T> HaalGegevens(String url,Type typ)
			throws ClientProtocolException, IOException {
		Gson gson = new GsonBuilder().serializeNulls().create();
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(url);
		request.setHeader("Authorization", "Bearer ZfmgrSW85TXRy9V_xQ7t7NIRiydl0iITdYCcbCTfLwFuWYbphfEy7oCgBOTSvmRLYBR0ZQ9IzW2Ot7Ayln3UXpez1ZDEX8v5N1Y3uF_HXddnvr-5xPTa0W1B9_dDfqHIqwI8UJruM-ZkrssERWFuAPypztcPsj3vsB0DOtz63u1npCqWGt5mJj6HBoYf8WL9wt70ndzXvde6qDZ54yTQRs1tEWC0ZzteAZjhrVp1KHOyDhzXB70mjbMWJWIYLGiDghp9iTINV4LtI-CuH7Gd1t504Z7TPF1wRrDuNznMcKLurcoMktPxpAsVzWNy1prlfhumpMFRu8zTww0lqVjjXOJvXNIhDORnPd1ITwRPS-WG8sJrsFDeU_W7nhFcycLSM4EtkOpAaRcidhqXUL_WlEsgu_9Sq8-bNNPVSxto0KCo0Eb04JXppLCp-eR2rbYc-mV_RIcIqRKNU4zWO3k4voxH6UCoiigtTDY24NpD6mpiII59ZvwEsNaCsYplZY8EyWry26ZfL8uk3-buoOgoMg");
		HttpResponse response = client.execute(request);		
		BufferedReader rd = new BufferedReader(new InputStreamReader(response
				.getEntity().getContent()));

		ArrayList<T> lijst = gson.fromJson(rd, typ);
		return lijst;
	}
	
	public static void PostObject(String url, Object object)
			throws ClientProtocolException, IOException {
		Gson gson = new GsonBuilder().serializeNulls().create();
		String objectAsJson = gson.toJson(object);
		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost(url);
		post.setHeader("Authorization", "Bearer ZfmgrSW85TXRy9V_xQ7t7NIRiydl0iITdYCcbCTfLwFuWYbphfEy7oCgBOTSvmRLYBR0ZQ9IzW2Ot7Ayln3UXpez1ZDEX8v5N1Y3uF_HXddnvr-5xPTa0W1B9_dDfqHIqwI8UJruM-ZkrssERWFuAPypztcPsj3vsB0DOtz63u1npCqWGt5mJj6HBoYf8WL9wt70ndzXvde6qDZ54yTQRs1tEWC0ZzteAZjhrVp1KHOyDhzXB70mjbMWJWIYLGiDghp9iTINV4LtI-CuH7Gd1t504Z7TPF1wRrDuNznMcKLurcoMktPxpAsVzWNy1prlfhumpMFRu8zTww0lqVjjXOJvXNIhDORnPd1ITwRPS-WG8sJrsFDeU_W7nhFcycLSM4EtkOpAaRcidhqXUL_WlEsgu_9Sq8-bNNPVSxto0KCo0Eb04JXppLCp-eR2rbYc-mV_RIcIqRKNU4zWO3k4voxH6UCoiigtTDY24NpD6mpiII59ZvwEsNaCsYplZY8EyWry26ZfL8uk3-buoOgoMg");
		try {
            post.setEntity(new StringEntity(objectAsJson));
            HttpResponse response = client.execute(post);
            System.out.println(EntityUtils.toString(post.getEntity()));
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	//WERKT NOG NIET
	public static void DeleteObject(String url, Object object)
			throws ClientProtocolException, IOException {
		Gson gson = new GsonBuilder().serializeNulls().create();
		String objectAsJson = gson.toJson(object);
		HttpClient client = new DefaultHttpClient();
		HttpDelete delete = new HttpDelete(url);
		delete.setHeader("Authorization", "Bearer ZfmgrSW85TXRy9V_xQ7t7NIRiydl0iITdYCcbCTfLwFuWYbphfEy7oCgBOTSvmRLYBR0ZQ9IzW2Ot7Ayln3UXpez1ZDEX8v5N1Y3uF_HXddnvr-5xPTa0W1B9_dDfqHIqwI8UJruM-ZkrssERWFuAPypztcPsj3vsB0DOtz63u1npCqWGt5mJj6HBoYf8WL9wt70ndzXvde6qDZ54yTQRs1tEWC0ZzteAZjhrVp1KHOyDhzXB70mjbMWJWIYLGiDghp9iTINV4LtI-CuH7Gd1t504Z7TPF1wRrDuNznMcKLurcoMktPxpAsVzWNy1prlfhumpMFRu8zTww0lqVjjXOJvXNIhDORnPd1ITwRPS-WG8sJrsFDeU_W7nhFcycLSM4EtkOpAaRcidhqXUL_WlEsgu_9Sq8-bNNPVSxto0KCo0Eb04JXppLCp-eR2rbYc-mV_RIcIqRKNU4zWO3k4voxH6UCoiigtTDY24NpD6mpiII59ZvwEsNaCsYplZY8EyWry26ZfL8uk3-buoOgoMg");
		try {
            ((HttpResponse) delete).setEntity(new StringEntity(objectAsJson));
            HttpResponse response = client.execute(delete);
            //System.out.println(EntityUtils.toString(delete.deleteEntity()));
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
