package io.github.kelvao.cloudflarescrape;

import android.os.AsyncTask;

import java.util.HashMap;

public class CloudflareScrapTask extends AsyncTask<Void, Void, HashMap<String, String>> {

    private final String UA;
    private final String URL;
    private final Callback callback;

    CloudflareScrapTask(String UA, String URL, Callback callback) {
        this.UA = UA;
        this.URL = URL;
        this.callback = callback;
    }

    @Override
    protected HashMap<String, String> doInBackground(Void... voids) {
        CloudflareScrapeCore cloudflareScrapeCore = new CloudflareScrapeCore(URL);
        cloudflareScrapeCore.setUA(UA);
        return cloudflareScrapeCore.List2Map(cloudflareScrapeCore.cookies());
    }

    @Override
    protected void onPostExecute(HashMap<String, String> coockies) {
        callback.CloudflareScrapedCoockies(coockies);
    }

    public interface Callback {
        void CloudflareScrapedCoockies(HashMap<String, String> result);
    }
}
