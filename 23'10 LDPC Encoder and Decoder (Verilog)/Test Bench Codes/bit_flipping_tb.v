module bit_flipping_tb;
reg [5:0]fc,r;
reg clk;
wire [5:0]c;
bit_flipping uut(fc,r,clk,c);
initial
clk=1'b1;
always #10 clk=~clk;
initial
begin
fc=6'b010000; r=6'b111000;
#10 fc=6'b000010; r=6'b001100;
#10 $finish;
end
endmodule