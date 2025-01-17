package com.example.android_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Game_Jingziqi extends AppCompatActivity {

    private TextView player1,player2,turns,turn;
    private ImageView iv1,iv2,iv3,iv4,iv5,iv6,iv7,iv8,iv9;
    private int player1score,player2score,turns_number,times;
    private final int[][] result = new int[3][3];
    //flag用于标记“查看棋局”状态，避免查看棋局时结算分数
    private boolean flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_jingziqi);

        initView();
        initData();
        initViewOnClickListener();
    }

    private void message(int player) {
        AlertDialog dialog;
        AlertDialog.Builder builder = new AlertDialog.Builder(Game_Jingziqi.this)
                .setTitle("玩家" + player + "赢了！")                 //设置对话框的标题
                .setIcon(R.mipmap.ic_launcher)               //设置对话框标题图标
                //添加"确定"按钮
                .setPositiveButton("下一局", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();                             //关闭对话框
                        for (int i = 0;i < 3;i++) {
                            for (int j = 0;j < 3;j++) {
                                result[i][j] = 0;
                            }
                        }
                        flag = false;
                        times = 1;
                        turn.setText("玩家1的回合");
                        iv1.setImageDrawable(null);
                        iv2.setImageDrawable(null);
                        iv3.setImageDrawable(null);
                        iv4.setImageDrawable(null);
                        iv5.setImageDrawable(null);
                        iv6.setImageDrawable(null);
                        iv7.setImageDrawable(null);
                        iv8.setImageDrawable(null);
                        iv9.setImageDrawable(null);
                        initViewOnClickListener();
                    }
                })
                //添加“取消”按钮
                .setNegativeButton("查看棋局", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();                             //关闭对话框
                        flag = true;
                        turn.setText("查看棋局中");
                    }
                });
        dialog = builder.create();
        dialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialogInterface) {
                Button positiveButton = ((AlertDialog) dialog).getButton(DialogInterface.BUTTON_POSITIVE);
                Button negativeButton = ((AlertDialog) dialog).getButton(DialogInterface.BUTTON_NEGATIVE);

                // 设置确定按钮文本颜色
                positiveButton.setTextColor(ContextCompat.getColor(Game_Jingziqi.this, android.R.color.background_dark));

                // 设置取消按钮文本颜色
                negativeButton.setTextColor(ContextCompat.getColor(Game_Jingziqi.this, android.R.color.background_dark));
            }
        });
        dialog.show();
    }

    private void check1() {
        player1score += 1;
        turns_number += 1;
        Toast.makeText(this,"玩家1赢了！",Toast.LENGTH_SHORT).show();
        player1.setText("玩家1: " + player1score);
        turns.setText("回合数: " + turns_number);
        message(1);
    }

    private void check2() {
        player2score += 1;
        turns_number += 1;
        Toast.makeText(this,"玩家2赢了！",Toast.LENGTH_SHORT).show();
        player2.setText("玩家2: " + player2score);
        turns.setText("回合数: " + turns_number);
        message(2);
    }

    private void checkWin(int position) {
//        if (result[0][0]+result[0][1]+result[0][2] == 6) {
//            check1();
//        } else if (result[0][0]+result[0][1]+result[0][2] == -6) {
//            check2();
//        } else if (result[1][0]+result[1][1]+result[1][2] == 6) {
//            check1();
//        } else if (result[1][0]+result[1][1]+result[1][2] == -6) {
//            check2();
//        } else if (result[2][0]+result[2][1]+result[2][2] == 6) {
//            check1();
//        } else if (result[2][0]+result[2][1]+result[2][2] == -6) {
//            check2();
//        } else if (result[0][0]+result[1][0]+result[2][0] == 6) {
//            check1();
//        } else if (result[0][0]+result[1][0]+result[2][0] == -6) {
//            check2();
//        } else if (result[0][1]+result[1][1]+result[2][1] == 6) {
//            check1();
//        } else if (result[0][1]+result[1][1]+result[2][1] == -6) {
//            check2();
//        } else if (result[0][2]+result[1][2]+result[2][2] == 6) {
//            check1();
//        } else if (result[0][2]+result[1][2]+result[2][2] == -6) {
//            check2();
//        } else if (result[0][0]+result[1][1]+result[2][2] == 6) {
//            check1();
//        } else if (result[0][0]+result[1][1]+result[2][2] == -6) {
//            check2();
//        } else if (result[0][2]+result[1][1]+result[2][0] == 6) {
//            check1();
//        } else if (result[0][2]+result[1][1]+result[2][0] == -6) {
//            check2();
//        }
        if (position == 0) {
            if (result[0][0] + result[0][1] + result[0][2] == 6) {
                check1();
            } else if (result[0][0] + result[0][1] + result[0][2] == -6) {
                check2();
            } else if (result[0][0] + result[1][0] + result[2][0] == 6) {
                check1();
            } else if (result[0][0] + result[1][0] + result[2][0] == -6) {
                check2();
            } else if (result[0][0] + result[1][1] + result[2][2] == 6) {
                check1();
            } else if (result[0][0] + result[1][1] + result[2][2] == -6) {
                check2();
            }
        } else if (position == 1) {
            if (result[0][0] + result[0][1] + result[0][2] == 6) {
                check1();
            } else if (result[0][0] + result[0][1] + result[0][2] == -6) {
                check2();
            } else if (result[0][1] + result[1][1] + result[2][1] == 6) {
                check1();
            } else if (result[0][1] + result[1][1] + result[2][1] == -6) {
                check2();
            }
        } else if (position == 2) {
            if (result[0][0] + result[0][1] + result[0][2] == 6) {
                check1();
            } else if (result[0][0] + result[0][1] + result[0][2] == -6) {
                check2();
            } else if (result[0][2] + result[1][2] + result[2][2] == 6) {
                check1();
            } else if (result[0][2] + result[1][2] + result[2][2] == -6) {
                check2();
            } else if (result[0][2] + result[1][1] + result[2][0] == 6) {
                check1();
            } else if (result[0][2] + result[1][1] + result[2][0] == -6) {
                check2();
            }
        } else if (position == 3) {
            if (result[1][0] + result[1][1] + result[1][2] == 6) {
                check1();
            } else if (result[1][0] + result[1][1] + result[1][2] == -6) {
                check2();
            } else if (result[0][0] + result[1][0] + result[2][0] == 6) {
                check1();
            } else if (result[0][0] + result[1][0] + result[2][0] == -6) {
                check2();
            }
        } else if (position == 4) {
            if (result[1][0] + result[1][1] + result[1][2] == 6) {
                check1();
            } else if (result[1][0] + result[1][1] + result[1][2] == -6) {
                check2();
            } else if (result[0][1] + result[1][1] + result[2][1] == 6) {
                check1();
            } else if (result[0][1] + result[1][1] + result[2][1] == -6) {
                check2();
            } else if (result[0][0] + result[1][1] + result[2][2] == 6) {
                check1();
            } else if (result[0][0] + result[1][1] + result[2][2] == -6) {
                check2();
            } else if (result[0][2] + result[1][1] + result[2][0] == 6) {
                check1();
            } else if (result[0][2] + result[1][1] + result[2][0] == -6) {
                check2();
            }
        } else if (position == 5) {
            if (result[1][0] + result[1][1] + result[1][2] == 6) {
                check1();
            } else if (result[1][0] + result[1][1] + result[1][2] == -6) {
                check2();
            } else if (result[0][2] + result[1][2] + result[2][2] == 6) {
                check1();
            } else if (result[0][2] + result[1][2] + result[2][2] == -6) {
                check2();
            }
        } else if (position == 6) {
            if (result[2][0] + result[2][1] + result[2][2] == 6) {
                check1();
            } else if (result[2][0] + result[2][1] + result[2][2] == -6) {
                check2();
            } else if (result[0][0] + result[1][0] + result[2][0] == 6) {
                check1();
            } else if (result[0][0] + result[1][0] + result[2][0] == -6) {
                check2();
            } else if (result[0][2] + result[1][1] + result[2][0] == 6) {
                check1();
            } else if (result[0][2] + result[1][1] + result[2][0] == -6) {
                check2();
            }
        } else if (position == 7) {
            if (result[2][0] + result[2][1] + result[2][2] == 6) {
                check1();
            } else if (result[2][0] + result[2][1] + result[2][2] == -6) {
                check2();
            } else if (result[0][1] + result[1][1] + result[2][1] == 6) {
                check1();
            } else if (result[0][1] + result[1][1] + result[2][1] == -6) {
                check2();
            }
        } else if (position == 8) {
            if (result[2][0] + result[2][1] + result[2][2] == 6) {
                check1();
            } else if (result[2][0] + result[2][1] + result[2][2] == -6) {
                check2();
            } else if (result[0][2] + result[1][2] + result[2][2] == 6) {
                check1();
            } else if (result[0][2] + result[1][2] + result[2][2] == -6) {
                check2();
            } else if (result[0][0] + result[1][1] + result[2][2] == 6) {
                check1();
            } else if (result[0][0] + result[1][1] + result[2][2] == -6) {
                check2();
            }
        }
    }

    private void checkLighter() {
        if (times > 6) {
            if (times % 2 == 1) {
                for (int i = 0;i < 3;i++) {
                    for (int j = 0; j < 3; j++) {
                        if (result[i][j] == 1) {
                            result[i][j] = 0;
                            if (i == 0 && j == 0) {
                                iv1.setImageDrawable(getResources().getDrawable(R.drawable.baseline_radio_button_unchecked_24_lighter));
                            } else if (i == 0 && j == 1) {
                                iv2.setImageDrawable(getResources().getDrawable(R.drawable.baseline_radio_button_unchecked_24_lighter));
                            } else if (i == 0 && j == 2) {
                                iv3.setImageDrawable(getResources().getDrawable(R.drawable.baseline_radio_button_unchecked_24_lighter));
                            } else if (i == 1 && j == 0) {
                                iv4.setImageDrawable(getResources().getDrawable(R.drawable.baseline_radio_button_unchecked_24_lighter));
                            } else if (i == 1 && j == 1) {
                                iv5.setImageDrawable(getResources().getDrawable(R.drawable.baseline_radio_button_unchecked_24_lighter));
                            } else if (i == 1 && j == 2) {
                                iv6.setImageDrawable(getResources().getDrawable(R.drawable.baseline_radio_button_unchecked_24_lighter));
                            } else if (i == 2 && j == 0) {
                                iv7.setImageDrawable(getResources().getDrawable(R.drawable.baseline_radio_button_unchecked_24_lighter));
                            } else if (i == 2 && j == 1) {
                                iv8.setImageDrawable(getResources().getDrawable(R.drawable.baseline_radio_button_unchecked_24_lighter));
                            } else if (i == 2 && j == 2) {
                                iv9.setImageDrawable(getResources().getDrawable(R.drawable.baseline_radio_button_unchecked_24_lighter));
                            }
                        } else if (result[i][j] == 2) {
                            result[i][j] = 1;
                        } else if (result[i][j] == 3) {
                            result[i][j] = 2;
                        }
                    }
                }
            } else {
                for (int i = 0;i < 3;i++) {
                    for (int j = 0; j < 3; j++) {
                        if (result[i][j] == -1) {
                            result[i][j] = 0;
                            if (i == 0 && j == 0) {
                                iv1.setImageDrawable(getResources().getDrawable(R.drawable.baseline_close_24_lighter));
                            } else if (i == 0 && j == 1) {
                                iv2.setImageDrawable(getResources().getDrawable(R.drawable.baseline_close_24_lighter));
                            } else if (i == 0 && j == 2) {
                                iv3.setImageDrawable(getResources().getDrawable(R.drawable.baseline_close_24_lighter));
                            } else if (i == 1 && j == 0) {
                                iv4.setImageDrawable(getResources().getDrawable(R.drawable.baseline_close_24_lighter));
                            } else if (i == 1 && j == 1) {
                                iv5.setImageDrawable(getResources().getDrawable(R.drawable.baseline_close_24_lighter));
                            } else if (i == 1 && j == 2) {
                                iv6.setImageDrawable(getResources().getDrawable(R.drawable.baseline_close_24_lighter));
                            } else if (i == 2 && j == 0) {
                                iv7.setImageDrawable(getResources().getDrawable(R.drawable.baseline_close_24_lighter));
                            } else if (i == 2 && j == 1) {
                                iv8.setImageDrawable(getResources().getDrawable(R.drawable.baseline_close_24_lighter));
                            } else if (i == 2 && j == 2) {
                                iv9.setImageDrawable(getResources().getDrawable(R.drawable.baseline_close_24_lighter));
                            }
                        } else if (result[i][j] == -2) {
                            result[i][j] = -1;
                        } else if (result[i][j] == -3) {
                            result[i][j] = -2;
                        }
                    }
                }
            }
        }
    }

    private void checkFade() {
        for (int i = 0;i < 3;i++) {
            for (int j = 0;j < 3;j++) {
                if (result[i][j] == 0) {
                    if (i == 0 && j == 0) {
                        iv1.setImageDrawable(null);
                    } else if (i == 0 && j == 1) {
                        iv2.setImageDrawable(null);
                    } else if (i == 0 && j == 2) {
                        iv3.setImageDrawable(null);
                    } else if (i == 1 && j == 0) {
                        iv4.setImageDrawable(null);
                    } else if (i == 1 && j == 1) {
                        iv5.setImageDrawable(null);
                    } else if (i == 1 && j == 2) {
                        iv6.setImageDrawable(null);
                    } else if (i == 2 && j == 0) {
                        iv7.setImageDrawable(null);
                    } else if (i == 2 && j == 1) {
                        iv8.setImageDrawable(null);
                    } else if (i == 2 && j == 2) {
                        iv9.setImageDrawable(null);
                    }
                }
            }
        }
    }

    private void check(int position) {
        if (!flag) {
            checkWin(position);
        }
        checkFade();
        checkLighter();
    }

    private void initViewOnClickListener() {
        iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (result[0][0] == 0 && iv1.getDrawable() == null) {
                    if (times % 2 == 1) {
                        iv1.setImageDrawable(getResources().getDrawable(R.drawable.baseline_radio_button_unchecked_24));
                        turn.setText("玩家2的回合");
                        if (times > 6) {
                            result[0][0] = 3;
                        } else {
                            result[0][0] = (times % 6 + 1) / 2;
                        }
                    } else {
                        iv1.setImageDrawable(getResources().getDrawable(R.drawable.baseline_close_24));
                        turn.setText("玩家1的回合");
                        if (times > 6) {
                            result[0][0] = -3;
                        } else {
                            result[0][0] = -((times - 1) % 6 + 1) / 2;
                        }
                    }
                    times += 1;
                    check(0);
                }
            }
        });
        iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (result[0][1] == 0 && iv2.getDrawable() == null) {
                    if (times % 2 == 1) {
                        iv2.setImageDrawable(getResources().getDrawable(R.drawable.baseline_radio_button_unchecked_24));
                        turn.setText("玩家2的回合");
                        if (times > 6) {
                            result[0][1] = 3;
                        } else {
                            result[0][1] = (times % 6 + 1) / 2;
                        }
                    } else {
                        iv2.setImageDrawable(getResources().getDrawable(R.drawable.baseline_close_24));
                        turn.setText("玩家1的回合");
                        if (times > 6) {
                            result[0][1] = -3;
                        } else {
                            result[0][1] = -((times - 1) % 6 + 1) / 2;
                        }
                    }
                    times += 1;
                    check(1);
                }
            }
        });
        iv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (result[0][2] == 0 && iv3.getDrawable() == null) {
                    if (times % 2 == 1) {
                        iv3.setImageDrawable(getResources().getDrawable(R.drawable.baseline_radio_button_unchecked_24));
                        turn.setText("玩家2的回合");
                        if (times > 6) {
                            result[0][2] = 3;
                        } else {
                            result[0][2] = (times % 6 + 1) / 2;
                        }
                    } else {
                        iv3.setImageDrawable(getResources().getDrawable(R.drawable.baseline_close_24));
                        turn.setText("玩家1的回合");
                        if (times > 6) {
                            result[0][2] = -3;
                        } else {
                            result[0][2] = -((times - 1) % 6 + 1) / 2;
                        }
                    }
                    times += 1;
                    check(2);
                }
            }
        });
        iv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (result[1][0] == 0 && iv4.getDrawable() == null) {
                    if (times % 2 == 1) {
                        iv4.setImageDrawable(getResources().getDrawable(R.drawable.baseline_radio_button_unchecked_24));
                        turn.setText("玩家2的回合");
                        if (times > 6) {
                            result[1][0] = 3;
                        } else {
                            result[1][0] = (times % 6 + 1) / 2;
                        }
                    } else {
                        iv4.setImageDrawable(getResources().getDrawable(R.drawable.baseline_close_24));
                        turn.setText("玩家1的回合");
                        if (times > 6) {
                            result[1][0] = -3;
                        } else {
                            result[1][0] = -((times - 1) % 6 + 1) / 2;
                        }
                    }
                    times += 1;
                    check(3);
                }
            }
        });
        iv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (result[1][1] == 0 && iv5.getDrawable() == null) {
                    if (times % 2 == 1) {
                        iv5.setImageDrawable(getResources().getDrawable(R.drawable.baseline_radio_button_unchecked_24));
                        turn.setText("玩家2的回合");
                        if (times > 6) {
                            result[1][1] = 3;
                        } else {
                            result[1][1] = (times % 6 + 1) / 2;
                        }
                    } else {
                        iv5.setImageDrawable(getResources().getDrawable(R.drawable.baseline_close_24));
                        turn.setText("玩家1的回合");
                        if (times > 6) {
                            result[1][1] = -3;
                        } else {
                            result[1][1] = -((times - 1) % 6 + 1) / 2;
                        }
                    }
                    times += 1;
                    check(4);
                }
            }
        });
        iv6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (result[1][2] == 0 && iv6.getDrawable() == null) {
                    if (times % 2 == 1) {
                        iv6.setImageDrawable(getResources().getDrawable(R.drawable.baseline_radio_button_unchecked_24));
                        turn.setText("玩家2的回合");
                        if (times > 6) {
                            result[1][2] = 3;
                        } else {
                            result[1][2] = (times % 6 + 1) / 2;
                        }
                    } else {
                        iv6.setImageDrawable(getResources().getDrawable(R.drawable.baseline_close_24));
                        turn.setText("玩家1的回合");
                        if (times > 6) {
                            result[1][2] = -3;
                        } else {
                            result[1][2] = -((times - 1) % 6 + 1) / 2;
                        }
                    }
                    times += 1;
                    check(5);
                }
            }
        });
        iv7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (result[2][0] == 0 && iv7.getDrawable() == null) {
                    if (times % 2 == 1) {
                        iv7.setImageDrawable(getResources().getDrawable(R.drawable.baseline_radio_button_unchecked_24));
                        turn.setText("玩家2的回合");
                        if (times > 6) {
                            result[2][0] = 3;
                        } else {
                            result[2][0] = (times % 6 + 1) / 2;
                        }
                    } else {
                        iv7.setImageDrawable(getResources().getDrawable(R.drawable.baseline_close_24));
                        turn.setText("玩家1的回合");
                        if (times > 6) {
                            result[2][0] = -3;
                        } else {
                            result[2][0] = -((times - 1) % 6 + 1) / 2;
                        }
                    }
                    times += 1;
                    check(6);
                }
            }
        });
        iv8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (result[2][1] == 0 && iv8.getDrawable() == null) {
                    if (times % 2 == 1) {
                        iv8.setImageDrawable(getResources().getDrawable(R.drawable.baseline_radio_button_unchecked_24));
                        turn.setText("玩家2的回合");
                        if (times > 6) {
                            result[2][1] = 3;
                        } else {
                            result[2][1] = (times % 6 + 1) / 2;
                        }
                    } else {
                        iv8.setImageDrawable(getResources().getDrawable(R.drawable.baseline_close_24));
                        turn.setText("玩家1的回合");
                        if (times > 6) {
                            result[2][1] = -3;
                        } else {
                            result[2][1] = -((times - 1) % 6 + 1) / 2;
                        }
                    }
                    times += 1;
                    check(7);
                }
            }
        });
        iv9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (result[2][2] == 0 && iv9.getDrawable() == null) {
                    if (times % 2 == 1) {
                        iv9.setImageDrawable(getResources().getDrawable(R.drawable.baseline_radio_button_unchecked_24));
                        turn.setText("玩家2的回合");
                        if (times > 6) {
                            result[2][2] = 3;
                        } else {
                            result[2][2] = (times % 6 + 1) / 2;
                        }
                    } else {
                        iv9.setImageDrawable(getResources().getDrawable(R.drawable.baseline_close_24));
                        turn.setText("玩家1的回合");
                        if (times > 6) {
                            result[2][2] = -3;
                        } else {
                            result[2][2] = -((times - 1) % 6 + 1) / 2;
                        }
                    }
                    times += 1;
                    check(8);
                }
            }
        });
    }

    private void initData() {
        for (int i = 0;i < 3;i++) {
            for (int j = 0;j < 3;j++) {
                result[i][j] = 0;
            }
        }
        flag = false;
        times = 1;
        player1score = 0;
        player2score = 0;
        turns_number = 1;
        player1.setText("玩家1: " + player1score);
        player2.setText("玩家2: " + player2score);
        turns.setText("回合数: " + turns_number);
        turn.setText("玩家1的回合");
        iv1.setImageDrawable(null);
        iv2.setImageDrawable(null);
        iv3.setImageDrawable(null);
        iv4.setImageDrawable(null);
        iv5.setImageDrawable(null);
        iv6.setImageDrawable(null);
        iv7.setImageDrawable(null);
        iv8.setImageDrawable(null);
        iv9.setImageDrawable(null);
    }

    private void initView() {
        player1 = findViewById(R.id.tv_player1);
        player2 = findViewById(R.id.tv_player2);
        turns = findViewById(R.id.tv_turns);
        turn = findViewById(R.id.tv_turn);
        iv1 = findViewById(R.id.iv_1);
        iv2 = findViewById(R.id.iv_2);
        iv3 = findViewById(R.id.iv_3);
        iv4 = findViewById(R.id.iv_4);
        iv5 = findViewById(R.id.iv_5);
        iv6 = findViewById(R.id.iv_6);
        iv7 = findViewById(R.id.iv_7);
        iv8 = findViewById(R.id.iv_8);
        iv9 = findViewById(R.id.iv_9);
    }

    public void again(View view) {
        for (int i = 0;i < 3;i++) {
            for (int j = 0;j < 3;j++) {
                result[i][j] = 0;
            }
        }
        flag = false;
        times = 1;
        turn.setText("玩家1的回合");
        iv1.setImageDrawable(null);
        iv2.setImageDrawable(null);
        iv3.setImageDrawable(null);
        iv4.setImageDrawable(null);
        iv5.setImageDrawable(null);
        iv6.setImageDrawable(null);
        iv7.setImageDrawable(null);
        iv8.setImageDrawable(null);
        iv9.setImageDrawable(null);
        initViewOnClickListener();
    }

    public void restart(View view) {
        initData();
        initViewOnClickListener();
    }
}