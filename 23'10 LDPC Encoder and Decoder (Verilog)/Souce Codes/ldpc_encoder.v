module ldpc_encoder(u,p1,p2,p3,c); 
input [2:0]u;
input [5:0]p1,p2,p3;
output [5:0]c;
wire [5:0]c1,c2,c3;
generator_matrix ne(1'b1,p1,p2,p3,c1,c2,c3);
assign c=(c3*u[2])+(c2*u[1])+(c1*u[0]);
endmodule