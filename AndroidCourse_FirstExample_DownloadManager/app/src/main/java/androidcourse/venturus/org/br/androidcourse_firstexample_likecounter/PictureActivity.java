package androidcourse.venturus.org.br.androidcourse_firstexample_likecounter;

import android.app.DownloadManager;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class PictureActivity extends AppCompatActivity {

    private long downloadId = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);

        ImageView image = (ImageView) findViewById(R.id.marshmallow_big_image);

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DownloadManager downloadManager = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
                DownloadManager.Request request = new DownloadManager.Request(
                        Uri.parse("https://goo.gl/RnPVhk"));
                request.setTitle(getResources().getString(R.string.download_text));

                downloadId = downloadManager.enqueue(request);

                registerReceiver(new DownloadCompleteReceiver(downloadId), new IntentFilter(
                        DownloadManager.ACTION_DOWNLOAD_COMPLETE));
            }
        });
    }
}
