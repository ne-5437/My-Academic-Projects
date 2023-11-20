module generator_matrix(en,h1,h2,h3,g1,g2,g3);
integer i;
input [5:0]h1,h2,h3;
input en;
output reg [5:0]g1,g2,g3;
reg [2:0]w1,w2,w3;
always@(en or h1 or h2 or h3)
begin
for(i=5;i>2;i=i-1)
begin
w1[5-i]=h1[i];
w2[5-i]=h2[i];
w3[5-i]=h3[i];
end

g1[5]=w3[0];
g1[4]=w2[0];
g1[3]=w1[0];
g2[5]=w3[1];
g2[4]=w2[1];
g2[3]=w1[1];
g3[5]=w3[2];
g3[4]=w2[2];
g3[3]=w1[2];

g1[0]=1'b1;
g1[1]=1'b0;
g1[2]=1'b0;
g2[0]=1'b0;
g2[1]=1'b1;
g2[2]=1'b0;
g3[0]=1'b0;
g3[1]=1'b0;
g3[2]=1'b1;

end
endmodule
