package com.example.android_project;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Game_Jingziqi_Plus extends AppCompatActivity {

    private TextView player1,player2,turns,turn,rest1,rest3,rest9,rest_1,rest_3,rest_9;
    private ImageView iv1,iv2,iv3,iv4,iv5,iv6,iv7,iv8,iv9;
    private int player1score,player2score,turns_number,times,choose;
    private final int[][] result = new int[3][3], rest = new int[2][3];
    //flag用于标记“查看棋局”状态，避免查看棋局时结算分数
    private boolean flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_jingziqi_plus);

        initView();
        initData();
        initViewOnClickListener();
    }

    private void message(int player) {
        AlertDialog dialog;
        AlertDialog.Builder builder = new AlertDialog.Builder(Game_Jingziqi_Plus.this)
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
                        for (int i = 0;i < 2;i++) {
                            for (int j = 0;j < 3;j++) {
                                rest[i][j] = 3;
                            }
                        }
                        flag = false;
                        choose = 0;
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
                        rest1.setBackgroundColor(0xFFFFFFFF);
                        rest3.setBackgroundColor(0xFFFFFFFF);
                        rest9.setBackgroundColor(0xFFFFFFFF);
                        rest_1.setBackgroundColor(0xFFFFFFFF);
                        rest_3.setBackgroundColor(0xFFFFFFFF);
                        rest_9.setBackgroundColor(0xFFFFFFFF);
                        rest1.setText("小：" + rest[0][2]);
                        rest3.setText("中：" + rest[0][1]);
                        rest9.setText("大：" + rest[0][0]);
                        rest_1.setText("小：" + rest[1][2]);
                        rest_3.setText("中：" + rest[1][1]);
                        rest_9.setText("大：" + rest[1][0]);
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
                positiveButton.setTextColor(ContextCompat.getColor(Game_Jingziqi_Plus.this, android.R.color.background_dark));

                // 设置取消按钮文本颜色
                negativeButton.setTextColor(ContextCompat.getColor(Game_Jingziqi_Plus.this, android.R.color.background_dark));
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
        if (position == 0) {
            if (result[0][0] > 0 && result[0][1] > 0 && result[0][2] > 0) {
                check1();
            } else if (result[0][0] < 0 && result[0][1] < 0 && result[0][2] < 0) {
                check2();
            } else if (result[0][0] > 0 && result[1][0] > 0 && result[2][0] > 0) {
                check1();
            } else if (result[0][0] < 0 && result[1][0] < 0 && result[2][0] < 0) {
                check2();
            } else if (result[0][0] > 0 && result[1][1] > 0 && result[2][2] > 0) {
                check1();
            } else if (result[0][0] < 0 && result[1][1] < 0 && result[2][2] < 0) {
                check2();
            }
        } else if (position == 1) {
            if (result[0][0] > 0 && result[0][1] > 0 && result[0][2] > 0) {
                check1();
            } else if (result[0][0] < 0 && result[0][1] < 0 && result[0][2] < 0) {
                check2();
            } else if (result[0][1] > 0 && result[1][1] > 0 && result[2][1] > 0) {
                check1();
            } else if (result[0][1] < 0 && result[1][1] < 0 && result[2][1] < 0) {
                check2();
            }
        } else if (position == 2) {
            if (result[0][0] > 0 && result[0][1] > 0 && result[0][2] > 0) {
                check1();
            } else if (result[0][0] < 0 && result[0][1] < 0 && result[0][2] < 0) {
                check2();
            } else if (result[0][2] > 0 && result[1][2] > 0 && result[2][2] > 0) {
                check1();
            } else if (result[0][2] < 0 && result[1][2] < 0 && result[2][2] < 0) {
                check2();
            } else if (result[0][2] > 0 && result[1][1] > 0 && result[2][0] > 0) {
                check1();
            } else if (result[0][2] < 0 && result[1][1] < 0 && result[2][0] < 0) {
                check2();
            }
        } else if (position == 3) {
            if (result[1][0] > 0 && result[1][1] > 0 && result[1][2] > 0) {
                check1();
            } else if (result[1][0] < 0 && result[1][1] < 0 && result[1][2] < 0) {
                check2();
            } else if (result[0][0] > 0 && result[1][0] > 0 && result[2][0] > 0) {
                check1();
            } else if (result[0][0] < 0 && result[1][0] < 0 && result[2][0] < 0) {
                check2();
            }
        } else if (position == 4) {
            if (result[1][0] > 0 && result[1][1] > 0 && result[1][2] > 0) {
                check1();
            } else if (result[1][0] < 0 && result[1][1] < 0 && result[1][2] < 0) {
                check2();
            } else if (result[0][1] > 0 && result[1][1] > 0 && result[2][1] > 0) {
                check1();
            } else if (result[0][1] < 0 && result[1][1] < 0 && result[2][1] < 0) {
                check2();
            } else if (result[0][0] > 0 && result[1][1] > 0 && result[2][2] > 0) {
                check1();
            } else if (result[0][0] < 0 && result[1][1] < 0 && result[2][2] < 0) {
                check2();
            } else if (result[0][2] > 0 && result[1][1] > 0 && result[2][0] > 0) {
                check1();
            } else if (result[0][2] < 0 && result[1][1] < 0 && result[2][0] < 0) {
                check2();
            }
        } else if (position == 5) {
            if (result[1][0] > 0 && result[1][1] > 0 && result[1][2] > 0) {
                check1();
            } else if (result[1][0] < 0 && result[1][1] < 0 && result[1][2] < 0) {
                check2();
            } else if (result[0][2] > 0 && result[1][2] > 0 && result[2][2] > 0) {
                check1();
            } else if (result[0][2] < 0 && result[1][2] < 0 && result[2][2] < 0) {
                check2();
            }
        } else if (position == 6) {
            if (result[2][0] > 0 && result[2][1] > 0 && result[2][2] > 0) {
                check1();
            } else if (result[2][0] < 0 && result[2][1] < 0 && result[2][2] < 0) {
                check2();
            } else if (result[0][0] > 0 && result[1][0] > 0 && result[2][0] > 0) {
                check1();
            } else if (result[0][0] < 0 && result[1][0] < 0 && result[2][0] < 0) {
                check2();
            } else if (result[0][2] > 0 && result[1][1] > 0 && result[2][0] > 0) {
                check1();
            } else if (result[0][2] < 0 && result[1][1] < 0 && result[2][0] < 0) {
                check2();
            }
        } else if (position == 7) {
            if (result[2][0] > 0 && result[2][1] > 0 && result[2][2] > 0) {
                check1();
            } else if (result[2][0] < 0 && result[2][1] < 0 && result[2][2] < 0) {
                check2();
            } else if (result[0][1] > 0 && result[1][1] > 0 && result[2][1] > 0) {
                check1();
            } else if (result[0][1] < 0 && result[1][1] < 0 && result[2][1] < 0) {
                check2();
            }
        } else if (position == 8) {
            if (result[2][0] > 0 && result[2][1] > 0 && result[2][2] > 0) {
                check1();
            } else if (result[2][0] < 0 && result[2][1] < 0 && result[2][2] < 0) {
                check2();
            } else if (result[0][2] > 0 && result[1][2] > 0 && result[2][2] > 0) {
                check1();
            } else if (result[0][2] < 0 && result[1][2] < 0 && result[2][2] < 0) {
                check2();
            } else if (result[0][0] > 0 && result[1][1] > 0 && result[2][2] > 0) {
                check1();
            } else if (result[0][0] < 0 && result[1][1] < 0 && result[2][2] < 0) {
                check2();
            }
        }
    }

    @DrawableRes
    private int checkReplace(int result, int choose) {
        if (result == 0) {
            if (choose == 1) {
                return R.drawable.choose1;
            } else if (choose == 3) {
                return R.drawable.choose3;
            } else if (choose == 9) {
                return R.drawable.choose9;
            } else if (choose == -1) {
                return R.drawable.choose_1;
            } else if (choose == -3) {
                return R.drawable.choose_3;
            } else if (choose == -9) {
                return R.drawable.choose_9;
            }
        } else if (result == 1) {
            if (choose == 3) {
                return R.drawable.choose4;
            } else if (choose == 9) {
                return R.drawable.choose10;
            } else if (choose == -3) {
                return R.drawable.choose_2;
            } else if (choose == -9) {
                return R.drawable.choose_8;
            }
        } else if (result == 3) {
            if (choose == 9) {
                return R.drawable.choose12;
            } else if (choose == -9) {
                return R.drawable.choose_6;
            }
        } else if (result == 4) {
            if (choose == 9) {
                return R.drawable.choose13;
            } else if (choose == -9) {
                return R.drawable.choose_5;
            }
        } else if (result == 2) {
            if (choose == 9) {
                return R.drawable.choose11;
            } else if (choose == -9) {
                return R.drawable.choose_7;
            }
        } else if (result == -1) {
            if (choose == 3) {
                return R.drawable.choose2;
            } else if (choose == 9) {
                return R.drawable.choose8;
            } else if (choose == -3) {
                return R.drawable.choose_4;
            } else if (choose == -9) {
                return R.drawable.choose_10;
            }
        } else if (result == -3) {
            if (choose == 9) {
                return R.drawable.choose6;
            } else if (choose == -9) {
                return R.drawable.choose_12;
            }
        } else if (result == -4) {
            if (choose == 9) {
                return R.drawable.choose5;
            } else if (choose == -9) {
                return R.drawable.choose_13;
            }
        } else if (result == -2) {
            if (choose == 9) {
                return R.drawable.choose7;
            } else if (choose == -9) {
                return R.drawable.choose_11;
            }
        }
        return 0;
    }

    private void checkRest(int choose) {
        if (choose == 1) {
            rest[0][2] -= 1;
            rest1.setText("小：" + rest[0][2]);
        } else if (choose == 3) {
            rest[0][1] -= 1;
            rest3.setText("中：" + rest[0][1]);
        } else if (choose == 9) {
            rest[0][0] -= 1;
            rest9.setText("大：" + rest[0][0]);
        } else if (choose == -1) {
            rest[1][2] -= 1;
            rest_1.setText("小：" + rest[1][2]);
        } else if (choose == -3) {
            rest[1][1] -= 1;
            rest_3.setText("中：" + rest[1][1]);
        } else if (choose == -9) {
            rest[1][0] -= 1;
            rest_9.setText("大：" + rest[1][0]);
        }
    }

    private void check(int position) {
        if (!flag) {
            checkWin(position);
        }
        if (position == 0) {
            checkReplace(result[0][0], choose);
        } else if (position == 1) {

        }
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private void initViewOnClickListener() {

        iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!flag) {
                    if (times % 2 == 1) {
                        if (choose > 0 && checkReplace(result[0][0], choose) != 0) {
                            iv1.setImageDrawable(getResources().getDrawable(checkReplace(result[0][0], choose)));
                            turn.setText("玩家2的回合");
                            times += 1;
                            result[0][0] = result[0][0] + choose;
                            checkRest(choose);
                            check(0);
                        }
                    } else {
                        if (choose < 0 && checkReplace(result[0][0], choose) != 0) {
                            iv1.setImageDrawable(getResources().getDrawable(checkReplace(result[0][0], choose)));
                            turn.setText("玩家1的回合");
                            times += 1;
                            result[0][0] = result[0][0] + choose;
                            checkRest(choose);
                            check(0);
                        }
                    }
                }
            }
        });
        iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!flag) {
                    if (times % 2 == 1) {
                        if (choose > 0 && checkReplace(result[0][1], choose) != 0) {
                            iv2.setImageDrawable(getResources().getDrawable(checkReplace(result[0][1], choose)));
                            turn.setText("玩家2的回合");
                            times += 1;
                            result[0][1] = result[0][1] + choose;
                            checkRest(choose);
                            check(1);
                        }
                    } else {
                        if (choose < 0 && checkReplace(result[0][1], choose) != 0) {
                            iv2.setImageDrawable(getResources().getDrawable(checkReplace(result[0][1], choose)));
                            turn.setText("玩家1的回合");
                            times += 1;
                            result[0][1] = result[0][1] + choose;
                            checkRest(choose);
                            check(1);
                        }
                    }
                }
            }
        });
        iv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!flag) {
                    if (times % 2 == 1) {
                        if (choose > 0 && checkReplace(result[0][2], choose) != 0) {
                            iv3.setImageDrawable(getResources().getDrawable(checkReplace(result[0][2], choose)));
                            turn.setText("玩家2的回合");
                            times += 1;
                            result[0][2] = result[0][2] + choose;
                            checkRest(choose);
                            check(2);
                        }
                    } else {
                        if (choose < 0 && checkReplace(result[0][2], choose) != 0) {
                            iv3.setImageDrawable(getResources().getDrawable(checkReplace(result[0][2], choose)));
                            turn.setText("玩家1的回合");
                            times += 1;
                            result[0][2] = result[0][2] + choose;
                            checkRest(choose);
                            check(2);
                        }
                    }
                }
            }
        });
        iv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!flag) {
                    if (times % 2 == 1) {
                        if (choose > 0 && checkReplace(result[1][0], choose) != 0) {
                            iv4.setImageDrawable(getResources().getDrawable(checkReplace(result[1][0], choose)));
                            turn.setText("玩家2的回合");
                            times += 1;
                            result[1][0] = result[1][0] + choose;
                            checkRest(choose);
                            check(3);
                        }
                    } else {
                        if (choose < 0 && checkReplace(result[1][0], choose) != 0) {
                            iv4.setImageDrawable(getResources().getDrawable(checkReplace(result[1][0], choose)));
                            turn.setText("玩家1的回合");
                            times += 1;
                            result[1][0] = result[1][0] + choose;
                            checkRest(choose);
                            check(3);
                        }
                    }
                }
            }
        });
        iv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!flag) {
                    if (times % 2 == 1) {
                        if (choose > 0 && checkReplace(result[1][1], choose) != 0) {
                            iv5.setImageDrawable(getResources().getDrawable(checkReplace(result[1][1], choose)));
                            turn.setText("玩家2的回合");
                            times += 1;
                            result[1][1] = result[1][1] + choose;
                            checkRest(choose);
                            check(4);
                        }
                    } else {
                        if (choose < 0 && checkReplace(result[1][1], choose) != 0) {
                            iv5.setImageDrawable(getResources().getDrawable(checkReplace(result[1][1], choose)));
                            turn.setText("玩家1的回合");
                            times += 1;
                            result[1][1] = result[1][1] + choose;
                            checkRest(choose);
                            check(4);
                        }
                    }
                }
            }
        });
        iv6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!flag) {
                    if (times % 2 == 1) {
                        if (choose > 0 && checkReplace(result[1][2], choose) != 0) {
                            iv6.setImageDrawable(getResources().getDrawable(checkReplace(result[1][2], choose)));
                            turn.setText("玩家2的回合");
                            times += 1;
                            result[1][2] = result[1][2] + choose;
                            checkRest(choose);
                            check(5);
                        }
                    } else {
                        if (choose < 0 && checkReplace(result[1][2], choose) != 0) {
                            iv6.setImageDrawable(getResources().getDrawable(checkReplace(result[1][2], choose)));
                            turn.setText("玩家1的回合");
                            times += 1;
                            result[1][2] = result[1][2] + choose;
                            checkRest(choose);
                            check(5);
                        }
                    }
                }
            }
        });
        iv7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!flag) {
                    if (times % 2 == 1) {
                        if (choose > 0 && checkReplace(result[2][0], choose) != 0) {
                            iv7.setImageDrawable(getResources().getDrawable(checkReplace(result[2][0], choose)));
                            turn.setText("玩家2的回合");
                            times += 1;
                            result[2][0] = result[2][0] + choose;
                            checkRest(choose);
                            check(6);
                        }
                    } else {
                        if (choose < 0 && checkReplace(result[2][0], choose) != 0) {
                            iv7.setImageDrawable(getResources().getDrawable(checkReplace(result[2][0], choose)));
                            turn.setText("玩家1的回合");
                            times += 1;
                            result[2][0] = result[2][0] + choose;
                            checkRest(choose);
                            check(6);
                        }
                    }
                }
            }
        });
        iv8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!flag) {
                    if (times % 2 == 1) {
                        if (choose > 0 && checkReplace(result[2][1], choose) != 0) {
                            iv8.setImageDrawable(getResources().getDrawable(checkReplace(result[2][1], choose)));
                            turn.setText("玩家2的回合");
                            times += 1;
                            result[2][1] = result[2][1] + choose;
                            checkRest(choose);
                            check(7);
                        }
                    } else {
                        if (choose < 0 && checkReplace(result[2][1], choose) != 0) {
                            iv8.setImageDrawable(getResources().getDrawable(checkReplace(result[2][1], choose)));
                            turn.setText("玩家1的回合");
                            times += 1;
                            result[2][1] = result[2][1] + choose;
                            checkRest(choose);
                            check(7);
                        }
                    }
                }
            }
        });
        iv9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!flag) {
                    if (times % 2 == 1) {
                        if (choose > 0 && checkReplace(result[2][2], choose) != 0) {
                            iv9.setImageDrawable(getResources().getDrawable(checkReplace(result[2][2], choose)));
                            turn.setText("玩家2的回合");
                            times += 1;
                            result[2][2] = result[2][2] + choose;
                            checkRest(choose);
                            check(8);
                        }
                    } else {
                        if (choose < 0 && checkReplace(result[2][2], choose) != 0) {
                            iv9.setImageDrawable(getResources().getDrawable(checkReplace(result[2][2], choose)));
                            turn.setText("玩家1的回合");
                            times += 1;
                            result[2][2] = result[2][2] + choose;
                            checkRest(choose);
                            check(8);
                        }
                    }
                }
            }
        });
        rest1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rest[0][2] > 0) {
                    choose = 1;
                    rest1.setBackgroundColor(0x88888888);
                    rest3.setBackgroundColor(0xFFFFFFFF);
                    rest9.setBackgroundColor(0xFFFFFFFF);
                    rest_1.setBackgroundColor(0xFFFFFFFF);
                    rest_3.setBackgroundColor(0xFFFFFFFF);
                    rest_9.setBackgroundColor(0xFFFFFFFF);
                }
            }
        });
        rest3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rest[0][1] > 0) {
                    choose = 3;
                    rest1.setBackgroundColor(0xFFFFFFFF);
                    rest3.setBackgroundColor(0x88888888);
                    rest9.setBackgroundColor(0xFFFFFFFF);
                    rest_1.setBackgroundColor(0xFFFFFFFF);
                    rest_3.setBackgroundColor(0xFFFFFFFF);
                    rest_9.setBackgroundColor(0xFFFFFFFF);
                }
            }
        });
        rest9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rest[0][0] > 0) {
                    choose = 9;
                    rest1.setBackgroundColor(0xFFFFFFFF);
                    rest3.setBackgroundColor(0xFFFFFFFF);
                    rest9.setBackgroundColor(0x88888888);
                    rest_1.setBackgroundColor(0xFFFFFFFF);
                    rest_3.setBackgroundColor(0xFFFFFFFF);
                    rest_9.setBackgroundColor(0xFFFFFFFF);
                }
            }
        });
        rest_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rest[1][2] > 0) {
                    choose = -1;
                    rest1.setBackgroundColor(0xFFFFFFFF);
                    rest3.setBackgroundColor(0xFFFFFFFF);
                    rest9.setBackgroundColor(0xFFFFFFFF);
                    rest_1.setBackgroundColor(0x88888888);
                    rest_3.setBackgroundColor(0xFFFFFFFF);
                    rest_9.setBackgroundColor(0xFFFFFFFF);
                }
            }
        });
        rest_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rest[1][1] > 0) {
                    choose = -3;
                    rest1.setBackgroundColor(0xFFFFFFFF);
                    rest3.setBackgroundColor(0xFFFFFFFF);
                    rest9.setBackgroundColor(0xFFFFFFFF);
                    rest_1.setBackgroundColor(0xFFFFFFFF);
                    rest_3.setBackgroundColor(0x88888888);
                    rest_9.setBackgroundColor(0xFFFFFFFF);
                }
            }
        });
        rest_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rest[1][0] > 0) {
                    choose = -9;
                    rest1.setBackgroundColor(0xFFFFFFFF);
                    rest3.setBackgroundColor(0xFFFFFFFF);
                    rest9.setBackgroundColor(0xFFFFFFFF);
                    rest_1.setBackgroundColor(0xFFFFFFFF);
                    rest_3.setBackgroundColor(0xFFFFFFFF);
                    rest_9.setBackgroundColor(0x88888888);
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
        for (int i = 0;i < 2;i++) {
            for (int j = 0;j < 3;j++) {
                rest[i][j] = 3;
            }
        }
        flag = false;
        choose = 0;
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
        rest1.setText("小：" + rest[0][2]);
        rest3.setText("中：" + rest[0][1]);
        rest9.setText("大：" + rest[0][0]);
        rest_1.setText("小：" + rest[1][2]);
        rest_3.setText("中：" + rest[1][1]);
        rest_9.setText("大：" + rest[1][0]);
        rest1.setBackgroundColor(0xFFFFFFFF);
        rest3.setBackgroundColor(0xFFFFFFFF);
        rest9.setBackgroundColor(0xFFFFFFFF);
        rest_1.setBackgroundColor(0xFFFFFFFF);
        rest_3.setBackgroundColor(0xFFFFFFFF);
        rest_9.setBackgroundColor(0xFFFFFFFF);
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
        rest1 = findViewById(R.id.blue_small);
        rest3 = findViewById(R.id.blue_middle);
        rest9 = findViewById(R.id.blue_big);
        rest_1 = findViewById(R.id.red_small);
        rest_3 = findViewById(R.id.red_middle);
        rest_9 = findViewById(R.id.red_big);
    }

    public void again(View view) {
        for (int i = 0;i < 3;i++) {
            for (int j = 0;j < 3;j++) {
                result[i][j] = 0;
            }
        }
        for (int i = 0;i < 2;i++) {
            for (int j = 0;j < 3;j++) {
                rest[i][j] = 3;
            }
        }
        flag = false;
        choose = 0;
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
        rest1.setBackgroundColor(0xFFFFFFFF);
        rest3.setBackgroundColor(0xFFFFFFFF);
        rest9.setBackgroundColor(0xFFFFFFFF);
        rest_1.setBackgroundColor(0xFFFFFFFF);
        rest_3.setBackgroundColor(0xFFFFFFFF);
        rest_9.setBackgroundColor(0xFFFFFFFF);
        initViewOnClickListener();
    }

    public void restart(View view) {
        initData();
        initViewOnClickListener();
    }
}