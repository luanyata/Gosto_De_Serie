package br.com.luanyata.qualserie;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
    private SeekBar barra;
    private ImageView imagemExibicao;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        barra = (SeekBar) findViewById(R.id.seekBarId);
        imagemExibicao = (ImageView) findViewById(R.id.ImagaExibeId);


        barra.setMax(4);
        barra.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int valorProgresso = i;

                if (valorProgresso == 1)
                    imagemExibicao.setImageResource(R.drawable.pouco);
                else if (valorProgresso == 2)
                    imagemExibicao.setImageResource(R.drawable.medio);
                else if (valorProgresso == 3)
                    imagemExibicao.setImageResource(R.drawable.muito);
                else if (valorProgresso == 4) {
                    imagemExibicao.setImageResource(R.drawable.susto);
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.grito);
                    tocarSom();

                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                new Throwable("Not Implemented");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                new Throwable("Not Implemented");
            }
        });
    }

    private void tocarSom() {
        if (mediaPlayer != null) {
            mediaPlayer.start();
        }
    }

    @Override
    protected void onDestroy() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
        super.onDestroy();
    }

}
