

#include <reg51.h>
void umSequencial(){
int i;
P0 = 0b00000000;
    for(i = 0; i<8;i++){
        if(i==0){
        P0_0 = 0b1;
        } else if(i==1){
        P0_1 = 0b1;
        } else if(i==2){
        P0_2 = 0b1;
        } else if(i==3){
        P0_3 = 0b1;
        } else if(i==4){
        P0_4 = 0b1;
        } else if(i==5){
        P0_5 = 0b1;
        } else if(i==6){
        P0_6 = 0b1;
        } else if(i==7){
        P0_7 = 0b1;
        }
    }
}
void duplaSequencial(){
    int i;
    P0 = 0b00000000;
    for(i=0; i<4; i++){
        if(i==0){
        P0_0 = 0b1;
        P0_1 = 0b1;}
        else if(i==1){
        P0_2 = 0b1;
        P0_3 = 0b1;}
        else if(i==2){
        P0_4 = 0b1;
        P0_5 = 0b1;}
        else if(i==3){
        P0_6 = 0b1;
        P0_7 = 0b1;}
    }
}
void umNaoSequencial(){
    int i;
    for(i = 0; i<3;i++){
        P0 = 0b00000000;
        P0_0 = 0b1;
        P0_2 = 0b1;
        P0_1 = 0b1;
        P0_4 = 0b1;
        P0_7 = 0b1;
        P0_6 = 0b1;
        P0_5 = 0b1;
        P0_3 = 0b1;
    }
}
void duplaNaoSequencial(){
    int i;
    P0 = 0b00000000;
    for(i=0; i<4; i++){
        if(i==0){
        P0_0 = 0b1;
        P0_6 = 0b1;}
        else if(i==1){
        P0_1 = 0b1;
        P0_3 = 0b1;}
        else if(i==2){
        P0_2 = 0b1;
        P0_4 = 0b1;}
        else if(i==4){
        P0_5 = 0b1;
        P0_7 = 0b1;}
    }
}
void main(){
    umSequencial();
    duplaSequencial();
    umNaoSequencial();
    duplaNaoSequencial();
    return;
}
