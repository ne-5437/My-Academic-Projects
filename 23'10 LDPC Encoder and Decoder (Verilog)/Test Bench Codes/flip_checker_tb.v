module flip_checker_tb;
reg [2:0]sy;
reg [5:0]c1,c2,c3;
reg clk;
wire [5:0]v;
flip_checker uut(sy,c1,c2,c3,clk,v);
initial
clk=1'b1;
always #10 clk=~clk;
initial
begin
c1=6'b101101; c2=6'b100001; c3=6'b011010;sy=3'b110; 
#10 sy=3'b101;
#10 sy=3'b011;
#10 $finish;
end
endmodule