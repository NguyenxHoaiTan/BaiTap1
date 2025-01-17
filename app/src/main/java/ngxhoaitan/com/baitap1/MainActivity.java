package ngxhoaitan.com.baitap1;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Ẩn thanh tiêu đề

        setContentView(R.layout.activity_main);

        // Khởi tạo Views
        EditText edtInput = findViewById(R.id.edtInput);
        Button btnProcess = findViewById(R.id.btnProcess);
        TextView tvOutput = findViewById(R.id.tvOutput);

        // Kích thước mảng
        int size = 10;

        // Giới hạn giá trị random (ví dụ: từ 0 đến 100)
        int min = 0;
        int max = 100;
        Random random = new Random();
        int[] randomArray = new int[size];

        for (int i = 0; i < size; i++) {
            randomArray[i] = random.nextInt((max - min) + 1) + min;  // Tạo số ngẫu nhiên trong khoảng [min, max]
        }

        ArrayList<Integer> oddNumbers = new ArrayList<>();
        ArrayList<Integer> evenNumbers = new ArrayList<>();

        for (int number : randomArray) {
            if (number % 2 == 0) {
                evenNumbers.add(number);
            } else {
                oddNumbers.add(number);
            }
        }

        Log.d("Numbers", "Odd Numbers: " + oddNumbers);
        Log.d("Numbers", "Even Numbers: " + evenNumbers);

        // Xử lý chuỗi khi nhấn nút
        btnProcess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = edtInput.getText().toString();
                if (!input.isEmpty()) {
                    // Đảo ngược và in hoa chuỗi
                    String[] words = input.split(" ");
                    StringBuilder reversed = new StringBuilder();
                    for (int i = words.length - 1; i >= 0; i--) {
                        reversed.append(words[i]).append(" ");
                    }

                    String result = reversed.toString().trim().toUpperCase();
                    tvOutput.setText(result);

                    Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập chuỗi!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}