module parity_check_tb;
reg [3:0]a,b;
wire c,d,x,y,p,q;
parity_check uut(a,b,c,d,x,y,p,q);
initial
begin 
    a=3;b=4;
#10 a[3]=1;b[3]=0;
#10 $finish;
end
endmodule