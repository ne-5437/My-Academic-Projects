module bit_flipping(fc,r,clk,c);
input [5:0]fc,r;
input clk;
output reg [5:0]c;
integer i;
always@(clk)
begin
for(i=0;i<6;i=i+1)
begin
if(fc[i])
begin
c[i]=~r[i];
end
else
begin
c[i]=r[i];
end
end
end
endmodule

