module parity_check(a,b,c,d,x,y,p,q);
input [3:0]a,b;
output c,d,x,y,p,q;
assign c=a[0]^a[1]^a[2];
assign d=b[0]^b[1]^b[2];
assign x=a[3];
assign y=b[3];
assign p=~(x^c);
assign q=~(y^d);
endmodule