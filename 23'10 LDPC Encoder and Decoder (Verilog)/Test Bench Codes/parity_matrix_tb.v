module parity_matrix_tb;
reg [2:0]u;
reg [3:0]y;
wire [3:0]c;
parity_matrix uut(u,y,c);
initial
 begin
y=4'b0011;
u=3'b011;
#10 u=3'b100;
#10 $finish;
end
endmodule