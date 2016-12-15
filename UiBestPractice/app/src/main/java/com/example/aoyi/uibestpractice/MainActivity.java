package com.example.aoyi.uibestpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Msg>msgList=new ArrayList<>();
    private EditText inputText;
    private Button send;
    private RecyclerView recyclerView;
    private MsgAdapter msgAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initMsg();
        inputText= (EditText) findViewById(R.id.edit_text);
        send= (Button) findViewById(R.id.message_send);
        recyclerView= (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager manager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        msgAdapter=new MsgAdapter(msgList);
        recyclerView.setAdapter(msgAdapter);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content=inputText.getText().toString();
                if (!"".equals(content)){{
                    Msg msg=new Msg(Msg.TYPE_SENT,content);
                    msgList.add(msg);
                    msgAdapter.notifyItemInserted(msgList.size()-1);
                    recyclerView.scrollToPosition(msgList.size()-1);
                    inputText.setText("");

                }
                }
            }
        });
    }

    private void initMsg() {
        Msg msg1=new Msg(Msg.TYPE_RECEIVED,"你好啊");
        msgList.add(msg1);
        Msg msg2=new Msg(Msg.TYPE_SENT,"你是哪位？");
        msgList.add(msg2);
        Msg msg3=new Msg(Msg.TYPE_RECEIVED,"我是小明");
        msgList.add(msg3);

    }
}
