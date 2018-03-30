package mihailproductions.com.cnpvalidatordemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import mihailproductions.com.cnp_validator.CNP;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.cnpET)
    EditText cnpET;
    @BindView(R.id.valid_status)
    TextView validStatus;
    @BindView(R.id.sex)
    TextView sex;
    @BindView(R.id.birthdate)
    TextView birthdate;
    @BindView(R.id.county)
    TextView county;
    @BindView(R.id.register_number)
    TextView registerNumber;
    @BindView(R.id.is_citizen)
    TextView isCitizen;
    @BindView(R.id.container)
    LinearLayout container;

    @BindString(R.string.valid) String valid;
    @BindString(R.string.invalid) String invalid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    public void checkCNP(View view) {
        CNP cnp = new CNP(this,cnpET.getText().toString());
        if(cnp.isValid()){
            container.setVisibility(View.VISIBLE);
            validStatus.setText(valid);
            sex.setText(cnp.getSex());
            birthdate.setText( new SimpleDateFormat("dd/MM/yy").format(cnp.getBirthdate()));
            county.setText(cnp.getCounty());
            registerNumber.setText(cnp.getRegisterNumber());
            isCitizen.setText(getString(R.string.citizen_response,cnp.isCitizen()));
        }else{
            container.setVisibility(View.GONE);
            validStatus.setText(invalid);
        }
    }
}
